package com.example.crud.domain.vaccine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VacineRepository extends JpaRepository<Vaccine, Long> {
}
