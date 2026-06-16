package com.fitapp.backend.controller;

import com.fitapp.backend.model.Scheda;
import com.fitapp.backend.service.SchedaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/schede")
@CrossOrigin(origins = "http://localhost:4200")
public class SchedaController {

    private final SchedaService schedaService;

    public SchedaController(SchedaService schedaService) {
        this.schedaService = schedaService;
    }

    @GetMapping
    public List<Scheda> getSchede() {
        return schedaService.getAllSchede();
    }

    @PostMapping
    public Scheda creaScheda(@RequestBody Scheda scheda) {
        return schedaService.salvaScheda(scheda);
    }
}