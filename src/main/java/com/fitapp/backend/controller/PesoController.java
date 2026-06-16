package com.fitapp.backend.controller;

import com.fitapp.backend.model.Peso;
import com.fitapp.backend.service.PesoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pesi")
@CrossOrigin(origins = "http://localhost:4200")
public class PesoController {

    private final PesoService pesoService;

    // Iniettiamo il Service invece del Repository
    public PesoController(PesoService pesoService) {
        this.pesoService = pesoService;
    }

    @GetMapping
    public List<Peso> getTuttiIPesi() {
        // Il controller delega la logica al service
        return pesoService.getAllPesiOrdinati();
    }

    @PostMapping
    public Peso aggiungiPeso(@RequestBody Peso peso) {
        return pesoService.salvaNuovoPeso(peso);
    }

    @DeleteMapping("/{id}")
    public void cancellaPeso(@PathVariable Long id) {
        pesoService.eliminaPeso(id);
    }
}
