package com.example.crud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    @GetMapping
    public ResponseEntity<String> getAllVaccines() {
        return ResponseEntity.ok("todo: implementar método");
    }
}
