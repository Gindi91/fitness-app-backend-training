package com.fitapp.backend;

import com.fitapp.backend.model.*;
import com.fitapp.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ArrayList;

@SpringBootApplication
public class FitnessAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessAppBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner caricaDatiDiProva(
            SchedaRepository schedaRepo,
            AlimentoRepository alimentoRepo,
            PesoRepository pesoRepo) {
        return (args) -> {
            // Pulizia iniziale di sicurezza ordinata per via delle relazioni
            alimentoRepo.deleteAll();
            pesoRepo.deleteAll();
            schedaRepo.deleteAll();

            // 1. Dati Palestra (già funzionanti)
            Scheda gambe = new Scheda();
            gambe.setNome("Gambe");
            gambe.setGiorniSettimana(Arrays.asList(1, 4));
            gambe.setEsercizi(new ArrayList<>(Arrays.asList(
                    new Esercizio(null, "Squat", 4, 10, 80.0, false, "Scendere sotto il parallelo"),
                    new Esercizio(null, "Leg Press", 3, 12, 120.0, false, ""),
                    new Esercizio(null, "Affondi", 3, 10, 20.0, false, "")
            )));
            schedaRepo.save(gambe);

            // 2. Nuovi Dati Alimenti (Rinominati)
            alimentoRepo.save(new Alimento(null, "Riso e Pollo", 300, 35, 60, 5, 0, LocalDate.now(), "Pranzo"));
            alimentoRepo.save(new Alimento(null, "Fage Total 0%", 200, 20, 6, 0, 0, LocalDate.now(), "Colazione"));

            // 3. Nuovi Dati Pesi (Rinominati)
            pesoRepo.save(new Peso(null, LocalDate.now().minusDays(2), 80.5));
            pesoRepo.save(new Peso(null, LocalDate.now().minusDays(1), 80.2));
            pesoRepo.save(new Peso(null, LocalDate.now(), 79.8));

            System.out.println("--- VERSIONE 2: CHECKPOINT DATI REALI PRONTO IN RAM ---");
        };
    }
}
