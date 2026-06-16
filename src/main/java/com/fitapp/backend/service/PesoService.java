package com.fitapp.backend.service;

import com.fitapp.backend.model.Peso;
import com.fitapp.backend.repository.PesoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Dice a Spring che questa classe contiene la logica di business
public class PesoService {

    private final PesoRepository pesoRepository;

    // Usiamo il costruttore per la Dependency Injection (approccio consigliato in azienda)
    public PesoService(PesoRepository pesoRepository) {
        this.pesoRepository = pesoRepository;
    }

    // Regola di business: recupera i pesi ordinati dal più vecchio al più recente per il grafico
    public List<Peso> getAllPesiOrdinati() {
        return pesoRepository.findAll()
                .stream()
                .sorted((p1, p2) -> p1.getData().compareTo(p2.getData()))
                .toList();
    }

    // Regola di business: prima di salvare, potremmo fare controlli (es. peso non negativo)
    public Peso salvaNuovoPeso(Peso nuovoPeso) {
        if (nuovoPeso.getValore() <= 0) {
            throw new IllegalArgumentException("Il valore del peso deve essere maggiore di zero.");
        }
        return pesoRepository.save(nuovoPeso);
    }

    public void eliminaPeso(Long id) {
        if (!pesoRepository.existsById(id)) {
            throw new RuntimeException("Impossibile eliminare: Peso non trovato con ID " + id);
        }
        pesoRepository.deleteById(id);
    }
}