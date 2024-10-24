package com.ac2.demo.controller;

import com.ac2.demo.dto.ProjetoDTO;
import com.ac2.demo.service.ProjetoService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("AC2/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Transactional
    @PostMapping("/addProjeto")
    public ResponseEntity<Void> adicionar(@RequestBody ProjetoDTO projeto) {
        projetoService.adicionarProjeto(projeto);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @GetMapping("/buscarProjeto/{id}")
    public ResponseEntity<ProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        ProjetoDTO projeto = projetoService.getProjetoWithFuncionarios(id);
        return ResponseEntity.ok(projeto);
    }

    @GetMapping("/buscarProjetosPorData")
    public ResponseEntity<List<ProjetoDTO>> buscarProjetosPorData(
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<ProjetoDTO> projetos = projetoService.getProjetosByDataInicioBetween(startDate, endDate);
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/addProjeto/{idProjeto}/funcionarios/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Integer idProjeto,
            @PathVariable Integer idFuncionario) {
        // Lógica para vincular funcionário
        return ResponseEntity.ok().build();
    }
}