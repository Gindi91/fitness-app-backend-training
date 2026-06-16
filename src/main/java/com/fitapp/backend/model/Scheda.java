package com.fitapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schede")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scheda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "scheda_id")
    private List<Esercizio> esercizi = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> giorniSettimana = new ArrayList<>();
}
