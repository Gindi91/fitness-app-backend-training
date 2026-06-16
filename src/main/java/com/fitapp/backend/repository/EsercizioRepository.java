package com.fitapp.backend.repository;

import com.fitapp.backend.model.Esercizio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsercizioRepository extends JpaRepository<Esercizio, Long> {
}
