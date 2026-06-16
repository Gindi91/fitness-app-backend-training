package com.fitapp.backend.controller;

import com.fitapp.backend.model.Esercizio;
import com.fitapp.backend.repository.EsercizioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Dice a Spring che questa classe espone API REST in formato JSON
@RequestMapping("/api/esercizi") // Tutte le URL di questo controller inizieranno con questo percorso
@CrossOrigin(origins = "http://localhost:4200") // Sblocca il CORS permettendo ad Angular di fare chiamate qui
public class EsercizioController {

    @Autowired // Inietta automaticamente l'istanza della Repository (Dependency Injection)
    private EsercizioRepository esercizioRepository;

    // 1. GET: http://localhost:8080/api/esercizi
    // Restituisce la lista di tutti gli esercizi presenti nel DB
    @GetMapping
    public ResponseEntity<List<Esercizio>> getAllEsercizi() {
        List<Esercizio> lista = esercizioRepository.findAll();
        return ResponseEntity.ok(lista); // Ritorna uno stato HTTP 200 OK con i dati
    }

    // 2. POST: http://localhost:8080/api/esercizi
    // Riceve un oggetto Esercizio da Angular e lo salva nel DB
    @PostMapping
    public ResponseEntity<Esercizio> createEsercizio(@RequestBody Esercizio nuovoEsercizio) {
        // @RequestBody prende il JSON inviato da Angular e lo mappa sulla classe Java
        Esercizio salvato = esercizioRepository.save(nuovoEsercizio);
        return ResponseEntity.ok(salvato);
    }

    // 3. DELETE: http://localhost:8080/api/esercizi/{id}
    // Elimina un esercizio in base all'ID passato nell'URL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEsercizio(@PathVariable Long id) {
        if (!esercizioRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Ritorna 404 se l'ID non esiste
        }
        esercizioRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Ritorna 204 No Content (eliminazione riuscita)
    }
}
