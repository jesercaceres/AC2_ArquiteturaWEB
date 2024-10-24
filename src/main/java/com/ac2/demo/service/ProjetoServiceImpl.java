package com.ac2.demo.service;

import com.ac2.demo.dto.ProjetoDTO;
import com.ac2.demo.model.ProjetoModel;
import com.ac2.demo.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public ProjetoDTO getProjetoWithFuncionarios(Integer id) {
        ProjetoModel projeto = projetoRepository.findProjetoWithFuncionarios(id);
        return convertToDTO(projeto);
    }

    @Override
    public List<ProjetoDTO> getProjetosByDataInicioBetween(LocalDate startDate, LocalDate endDate) {
        List<ProjetoModel> projetos = projetoRepository.findProjetosByDataInicioBetween(startDate, endDate);
        return projetos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ProjetoDTO convertToDTO(ProjetoModel projeto) {
        // Implementar a conversão de ProjetoModel para ProjetoDTO
        return new ProjetoDTO();
    }
}