package com.ac2.demo.controller;

import com.ac2.demo.dto.ProjetoDTO;
import com.ac2.demo.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("AC2/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/addProjeto")
    public ResponseEntity<Void> adicionar(@RequestBody ProjetoDTO projeto) {
        // lógica para adicionar o projeto
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscarProjeto/{id}")
    public ResponseEntity<ProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        ProjetoDTO projeto = projetoService.getProjetoWithFuncionarios(id);
        return ResponseEntity.ok(projeto);
    }

    @PostMapping("/addProjeto/{idProjeto}/funcionarios/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Integer idProjeto,
            @PathVariable Integer idFuncionario) {
        // Lógica para vincular funcionário
        return ResponseEntity.ok().build();
    }
}