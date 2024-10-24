package com.ac2.demo.service;

import com.ac2.demo.dto.SetorDTO;
import java.util.List;

public interface SetorService {
    List<SetorDTO> getAllWithFuncionarios();
    void adicionarSetor(SetorDTO setorDTO);
    
}