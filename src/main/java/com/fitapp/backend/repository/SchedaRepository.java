package com.fitapp.backend.repository;

import com.fitapp.backend.model.Scheda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedaRepository extends JpaRepository<Scheda, Long> {
}
