package com.ac2.demo.controller;

import com.ac2.demo.dto.SetorDTO;
import com.ac2.demo.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("AC2/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping("/addSetor")
    public ResponseEntity<Void> adicionar(@RequestBody SetorDTO setor) {
        setorService.adicionarSetor(setor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscarSetor/{idSetor}")
    public ResponseEntity<SetorDTO> buscarSetorPorId(@PathVariable Integer idSetor) {
        // Lógica para buscar setor por ID
        return ResponseEntity.ok(new SetorDTO());
    }
}