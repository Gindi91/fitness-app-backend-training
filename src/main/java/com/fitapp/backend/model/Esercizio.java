package com.fitapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "esercizi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Esercizio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento dell'ID
    private Long id;

    private String nome;
    private int serie;
    private int ripetizioni;
    private double carico;
    private boolean completato;
    private String note;
}
