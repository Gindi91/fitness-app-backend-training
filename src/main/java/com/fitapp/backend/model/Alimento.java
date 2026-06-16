package com.fitapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "alimenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int grammi;
    private int proteine;
    private int carboidrati;
    private int grassi;
    private int calorie;
    private java.time.LocalDate data;
    private String tag;
}

