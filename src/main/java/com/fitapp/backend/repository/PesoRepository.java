package com.fitapp.backend.repository;

import com.fitapp.backend.model.Peso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Long> {
}
