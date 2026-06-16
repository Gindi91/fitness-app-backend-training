package com.fitapp.backend.service;

import com.fitapp.backend.model.Scheda;
import com.fitapp.backend.repository.SchedaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchedaService {

    private final SchedaRepository schedaRepository;

    public SchedaService(SchedaRepository schedaRepository) {
        this.schedaRepository = schedaRepository;
    }

    public List<Scheda> getAllSchede() {
        return schedaRepository.findAll();
    }

    public Scheda salvaScheda(Scheda scheda) {
        if (scheda.getNome() == null || scheda.getNome().isBlank()) {
            throw new IllegalArgumentException("Il nome della scheda non può essere vuoto.");
        }
        return schedaRepository.save(scheda);
    }
}