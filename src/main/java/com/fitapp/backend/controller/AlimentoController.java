package com.fitapp.backend.controller;

import com.fitapp.backend.model.Alimento;
import com.fitapp.backend.service.AlimentoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alimenti")
@CrossOrigin(origins = "http://localhost:4200")
public class AlimentoController {

    private final AlimentoService alimentoService;

    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @GetMapping
    public List<Alimento> getAlimenti() {
        return alimentoService.getAllAlimenti();
    }

    @PostMapping
    public Alimento creaAlimento(@RequestBody Alimento alimento) {
        return alimentoService.salvaAlimento(alimento);
    }
}
