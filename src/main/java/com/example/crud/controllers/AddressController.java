package com.example.crud.controllers;

import com.example.crud.domain.address.Address;
import com.example.crud.domain.address.AddressRepository;
import com.example.crud.domain.address.RequestAddress;
import com.example.crud.domain.region.Region;
import com.example.crud.domain.region.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public ResponseEntity getAllAddresses() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressRepository.findById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity createAddress(@RequestBody @Valid RequestAddress body) {
        Region region = regionRepository.findById(body.idRegiao())
                .orElseThrow(() -> new EntityNotFoundException("Região não encontrada com o ID: " + body.idRegiao()));

        Address address = new Address(body);
        address.setRegiao(region);

        addressRepository.save(address);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateAddress(@PathVariable Long id, @RequestBody @Valid RequestAddress body) {
        Address address = addressRepository.findById(id).orElseThrow();
        address.setRua(body.rua());
        address.setBairro(body.bairro());
        address.setNumero(body.numero());
        address.setCep(body.cep());
        address.setRegiao(regionRepository.findById(body.idRegiao()).orElseThrow());
        return ResponseEntity.ok(addressRepository.save(address));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
