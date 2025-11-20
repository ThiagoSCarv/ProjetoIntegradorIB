package com.example.crud.controllers;

import com.example.crud.domain.patient.Patient;
import com.example.crud.domain.patient.PatientRepository;
import com.example.crud.domain.patientVaccine.PatientVaccine;
import com.example.crud.domain.patientVaccine.PatientVaccineRepository;
import com.example.crud.domain.patientVaccine.RequestPatientVaccine;
import com.example.crud.domain.region.Region;
import com.example.crud.domain.region.RegionRepository;
import com.example.crud.domain.vaccine.Vaccine;
import com.example.crud.domain.vaccine.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient-vaccine")
public class PatientVaccineController {
    @Autowired
    private PatientVaccineRepository patientVaccineRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public ResponseEntity getAllPatientVaccines() {
        return ResponseEntity.ok(patientVaccineRepository.findAll());
    }

    @PostMapping
    public ResponseEntity createPatientVaccine(@RequestBody @Valid RequestPatientVaccine body) {
        Patient patient = patientRepository.findById(body.idPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + body.idPaciente()));

        Vaccine vaccine = vaccineRepository.findById(body.idVacina())
                .orElseThrow(() -> new EntityNotFoundException("Vacina não encontrada com o ID: " + body.idVacina()));

        PatientVaccine patientVaccine = new PatientVaccine();
        patientVaccine.setPaciente(patient);
        patientVaccine.setVacina(vaccine);
        patientVaccine.setDose(body.dose());
        patientVaccine.setDataAplicacao(body.dataAplicacao());

        patientVaccineRepository.save(patientVaccine);
        return ResponseEntity.ok(patientVaccine);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updatePatientVaccine(@PathVariable Long id, @RequestBody @Valid RequestPatientVaccine body) {
        PatientVaccine patientVaccine = patientVaccineRepository.findById(id).orElseThrow();
        patientVaccine.setDose(body.dose());
        patientVaccine.setDataAplicacao(body.dataAplicacao());
        return ResponseEntity.ok(patientVaccineRepository.save(patientVaccine));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatientVaccine(@PathVariable Long id) {
        patientVaccineRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    // Métodos Auxiliares
    private List<PatientVaccine> filterByVaccine(Long vaccineId) {
        List<PatientVaccine> list = patientVaccineRepository.findAll();
        List<PatientVaccine> listFiltered = new ArrayList<>();

        for (PatientVaccine pv : list) {
            if (pv.getVacina().getId().equals(vaccineId)) {
                listFiltered.add(pv);
            }
        }
        return listFiltered;
    }

    // Relatórios
    // 1. Vacinado x Doente (Status)
    @GetMapping("/reports/vaccine/{vaccineId}/status")
    public ResponseEntity<Map<String, Double>> getReportVaccineVsStatus(@PathVariable Long vaccineId) {
        List<PatientVaccine> list = filterByVaccine(vaccineId);

        double total = list.size();
        if (total == 0) return ResponseEntity.ok(new HashMap<>());

        double saudavelCount = 0;
        double doenteCount = 0;

        for (PatientVaccine pv : list) {
            String status = String.valueOf(pv.getPaciente().getStatus());
            if ("SAUDAVEL".equals(status)) {
                saudavelCount++;
            } else if ("DOENTE".equals(status)) {
                doenteCount++;
            }
        }

        Map<String, Double> percentages = new HashMap<>();
        percentages.put("SAUDAVEL", (saudavelCount / total) * 100);
        percentages.put("DOENTE", (doenteCount / total) * 100);

        return ResponseEntity.ok(percentages);
    }

    // Vacinado x Escolaridade
    @GetMapping("/reports/vaccine/{vaccineId}/schooling")
    public ResponseEntity<Map<String, Double>> getReportVaccineVsEscolaridade(@PathVariable Long vaccineId) {
        List<PatientVaccine> list = filterByVaccine(vaccineId);

        double total = list.size();
        if (total == 0) return ResponseEntity.ok(new HashMap<>());

        // NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO

        double nenhumaCount = 0;
        double fundamentalCount = 0;
        double medioCount = 0;
        double superiorCount = 0;
        double posGradCount = 0;

        for (PatientVaccine pv : list) {
            String schooling = String.valueOf(pv.getPaciente().getEscolaridade());
            if ("NENHUMA".equals(schooling)) {
                nenhumaCount++;
            } else if ("FUNDAMENTAL".equals(schooling)) {
                fundamentalCount++;
            } else if ("MEDIO".equals(schooling)) {
                medioCount++;
            } else if ("SUPERIOR".equals(schooling)) {
                superiorCount++;
            } else if ("POS_GRADUACAO".equals(schooling)) {
                posGradCount++;
            }
        }

        Map<String, Double> percentages = new HashMap<>();
        percentages.put("NENHUMA", (nenhumaCount / total) * 100);
        percentages.put("FUNDAMENTAL", (fundamentalCount / total) * 100);
        percentages.put("MEDIO", (medioCount / total) * 100);
        percentages.put("SUPERIOR", (superiorCount / total) * 100);
        percentages.put("POS_GRADUACAO", (posGradCount / total) * 100);

        return ResponseEntity.ok(percentages);
    }

    @GetMapping("/reports/vaccine/{vaccineId}/region")
    public ResponseEntity<Map<String, Double>> getReportVaccineVsRegiao(@PathVariable Long vaccineId) {
        // 1. Filtra as vacinas aplicadas
        List<PatientVaccine> list = filterByVaccine(vaccineId);
        double total = list.size();

        // 2. Busca TODAS as regiões possíveis no banco para garantir que apareçam
        List<Region> todasRegioes = regionRepository.findAll();

        // 3. Inicializa o mapa com TODAS as regiões com valor 0.0
        // Assim, se ninguém da "Região Norte" vacinou, ela aparece como 0%
        Map<String, Double> counts = new HashMap<>();
        for (Region r : todasRegioes) {
            counts.put(r.getNome(), 0.0);
        }

        // Se não tiver vacinas, retorna o mapa zerado (mas com os nomes das regiões!)
        if (total == 0) return ResponseEntity.ok(counts);

        // 4. Loop para contagem (Incrementa o que já existe no mapa)
        for (PatientVaccine pv : list) {
            String nomeRegiao = pv.getPaciente().getEndereco().getRegiao().getNome();

            // Verifica se a região do paciente ainda existe no banco (segurança)
            if (counts.containsKey(nomeRegiao)) {
                counts.put(nomeRegiao, counts.get(nomeRegiao) + 1.0);
            }
        }

        // 5. Calcula porcentagens
        Map<String, Double> percentages = new HashMap<>();
        for (String regiao : counts.keySet()) {
            double count = counts.get(regiao);
            percentages.put(regiao, (count / total) * 100);
        }

        return ResponseEntity.ok(percentages);
    }
}

//public ResponseEntity<Map<String, Double>> getReportVaccineVsEscolaridade(@PathVariable Long vaccineId) {
//    List<PatientVaccine> list = filterByVaccine(vaccineId);
//
//    double total = list.size();
//    if (total == 0) return ResponseEntity.ok(new HashMap<>());
//
//    // NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO
//
//    double nenhumaCount = 0;
//    double fundamentalCount = 0;
//    double medioCount = 0;
//    double superiorCount = 0;
//    double posGradCount = 0;
//
//    for (PatientVaccine pv : list) {
//        String status = String.valueOf(pv.getPaciente().getEscolaridade());
//        if ("NENHUMA".equals(status)) {
//            nenhumaCount++;
//        } else if ("FUNDAMENTAL".equals(status)) {
//            fundamentalCount++;
//        } else if ("MEDIO".equals(status)) {
//            medioCount++;
//        } else if ("SUPERIOR".equals(status)) {
//            superiorCount++;
//        } else if ("POS_GRADUACAO".equals(status)) {
//            posGradCount++;
//        }
//    }
//
//    Map<String, Double> percentages = new HashMap<>();
//    percentages.put("NENHUMA", (nenhumaCount / total) * 100);
//    percentages.put("FUNDAMENTAL", (fundamentalCount / total) * 100);
//    percentages.put("MEDIO", (medioCount / total) * 100);
//    percentages.put("SUPERIOR", (superiorCount / total) * 100);
//    percentages.put("POS_GRADUACAO", (posGradCount / total) * 100);
//
//    return ResponseEntity.ok(percentages);
//}