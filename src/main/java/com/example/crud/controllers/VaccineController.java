package com.example.crud.controllers;

import com.example.crud.domain.vaccine.RequestVaccine;
import com.example.crud.domain.vaccine.Vaccine;
import com.example.crud.domain.vaccine.VaccineRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    @Autowired
    private VaccineRepository vaccineRepository;

    @GetMapping
    public ResponseEntity getAllVaccines() {
        return ResponseEntity.ok(vaccineRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getVaccineById(@PathVariable Long id) {
        return ResponseEntity.ok(vaccineRepository.findById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity createVaccine(@RequestBody @Valid RequestVaccine body) {
        Vaccine vaccine = new Vaccine(body);
        vaccineRepository.save(vaccine);
        return ResponseEntity.ok(vaccine);
    }

    @PutMapping("/{id}")
    public Vaccine updateVaccine(@PathVariable Long id, @RequestBody RequestVaccine body) {
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow();
        vaccine.setNome(body.nome());
        vaccine.setTratamento(body.tratamento());
        vaccine.setQtdDoses(body.qtdDoses());
        return vaccineRepository.save(vaccine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaccine(@PathVariable Long id) {
        vaccineRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
