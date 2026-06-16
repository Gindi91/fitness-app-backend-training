package com.fitapp.backend.service;

import com.fitapp.backend.model.Alimento;
import com.fitapp.backend.repository.AlimentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;

    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    public List<Alimento> getAllAlimenti() {
        return alimentoRepository.findAll();
    }

    public Alimento salvaAlimento(Alimento alimento) {
        // Regola di business: normalizza il nome in minuscolo con iniziale maiuscola
        if (alimento.getNome() != null && !alimento.getNome().isBlank()) {
            String nomeFormattato = alimento.getNome().trim();
            nomeFormattato = nomeFormattato.substring(0, 1).toUpperCase() + nomeFormattato.substring(1).toLowerCase();
            alimento.setNome(nomeFormattato);
        }
        return alimentoRepository.save(alimento);
    }
}
