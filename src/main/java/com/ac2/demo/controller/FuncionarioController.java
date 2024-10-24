package com.ac2.demo.controller;

import com.ac2.demo.dto.FuncionarioDTO;
import com.ac2.demo.dto.ProjetoDTO;
import com.ac2.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("AC2/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> adicionar(@RequestBody FuncionarioDTO funcionario) {
        funcionarioService.adicionarFuncionario(funcionario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idFuncionario}/projetos")
    public ResponseEntity<List<ProjetoDTO>> buscarProjetos(@PathVariable Integer idFuncionario) {
        List<ProjetoDTO> projetos = funcionarioService.getProjetosByFuncionarioId(idFuncionario);
        return ResponseEntity.ok(projetos);
    }
}