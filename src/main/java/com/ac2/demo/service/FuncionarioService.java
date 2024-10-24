package com.ac2.demo.service;

import com.ac2.demo.dto.FuncionarioDTO;
import com.ac2.demo.dto.ProjetoDTO;
import java.util.List;

public interface FuncionarioService {
    List<ProjetoDTO> getProjetosByFuncionarioId(Integer id);
    void adicionarFuncionario(FuncionarioDTO funcionarioDTO);
}