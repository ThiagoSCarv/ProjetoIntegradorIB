package com.example.crud.controllers;

import com.example.crud.domain.patient.Patient;
import com.example.crud.domain.patient.PatientRepository;
import com.example.crud.domain.patientVaccine.PatientVaccine;
import com.example.crud.domain.patientVaccine.PatientVaccineRepository;
import com.example.crud.domain.patientVaccine.RequestPatientVaccine;
import com.example.crud.domain.vaccine.Vaccine;
import com.example.crud.domain.vaccine.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient-vaccine")
public class PatientVaccineController {
    @Autowired
    private PatientVaccineRepository patientVaccineRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

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
}
