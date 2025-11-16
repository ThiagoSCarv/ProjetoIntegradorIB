package com.example.crud.controllers;

import com.example.crud.domain.address.Address;
import com.example.crud.domain.address.AddressRepository;
import com.example.crud.domain.patient.PatientRepository;
import com.example.crud.domain.patient.RequestPatient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crud.domain.patient.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity getAllPatients() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientRepository.findById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity createPatient(@RequestBody @Valid RequestPatient body) {
        Address address = addressRepository.findById(body.idEndereco())
                .orElseThrow(() -> new EntityNotFoundException("Região não encontrada com o ID: " + body.idEndereco()));

        Patient patient = new Patient(body);
        patient.setEndereco(address);
        patientRepository.save(patient);
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updatePatient(@PathVariable Long id, @RequestBody @Valid RequestPatient body) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setNome(body.nome());
        patient.setCpf(body.cpf());
        patient.setTelefone(body.telefone());
        patient.setStatus(body.status());
        patient.setEscolaridade(body.escolaridade());
        patient.setDataNascimento(body.dataNascimento());
        patient.setEndereco(addressRepository.findById(body.idEndereco()).orElseThrow());
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
