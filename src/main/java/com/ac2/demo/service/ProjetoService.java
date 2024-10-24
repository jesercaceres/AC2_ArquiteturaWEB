package com.ac2.demo.service;

import com.ac2.demo.dto.ProjetoDTO;
import java.time.LocalDate;
import java.util.List;

public interface ProjetoService {
    ProjetoDTO getProjetoWithFuncionarios(Integer id);

    List<ProjetoDTO> getProjetosByDataInicioBetween(LocalDate startDate, LocalDate endDate);

    void adicionarProjeto(ProjetoDTO projetoDTO);
}