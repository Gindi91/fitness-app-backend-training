package com.fitapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
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

    // Gestione dei giorni della settimana (array di interi mapped come collection)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "scheda_giorni", joinColumns = @JoinColumn(name = "scheda_id"))
    @Column(name = "giorno")
    private List<Integer> giorniSettimana;

    // Relazione: Una scheda ha molti esercizi.
    // ALL cascata significa che se elimini/salvi una scheda, si aggiornano anche i suoi esercizi.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "scheda_id") // Crea la chiave esterna nella tabella esercizi
    private List<Esercizio> esercizi;
}
