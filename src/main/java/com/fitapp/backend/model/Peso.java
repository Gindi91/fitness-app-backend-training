package com.fitapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "pesi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Peso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anche 'date' è una parola riservata, per sicurezza mappiamo anche lei
    @Column(name = "data_misurazione")
    private LocalDate data;

    @Column(name = "valore_peso") // <--- FIX: Rinomina la colonna sul DB evitando 'value'
    private double valore;
}

