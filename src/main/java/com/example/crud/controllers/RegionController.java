package com.example.crud.controllers;

import com.example.crud.domain.region.Region;
import com.example.crud.domain.region.RegionRepository;
import com.example.crud.domain.region.RequestRegion;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionRepository regionRepository;
    @GetMapping
    public ResponseEntity getAllRegions() {
        return ResponseEntity.ok(regionRepository.findAll());
    }

    @PostMapping
    public ResponseEntity createRegion(@RequestBody @Valid RequestRegion body) {
        Region region = new Region(body);
        regionRepository.save(region);
        return ResponseEntity.ok(region);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateRegion(@PathVariable Long id, @RequestBody @Valid RequestRegion body) {
        Region region = regionRepository.findById(id).orElseThrow();
        region.setNome(body.nome());
        return ResponseEntity.ok(regionRepository.save(region));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRegion(@PathVariable Long id) {
        regionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
