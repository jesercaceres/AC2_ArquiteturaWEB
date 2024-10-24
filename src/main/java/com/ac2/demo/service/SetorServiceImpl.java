package com.ac2.demo.service;

import com.ac2.demo.dto.SetorDTO;
import com.ac2.demo.model.SetorModel;
import com.ac2.demo.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorServiceImpl implements SetorService {

    @Autowired
    private SetorRepository setorRepository;

    @Override
    public List<SetorDTO> getAllWithFuncionarios() {
        List<SetorModel> setores = setorRepository.findAllWithFuncionarios();
        return setores.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void adicionarSetor(SetorDTO setorDTO) {
        SetorModel setor = new SetorModel();
        setor.setNome(setorDTO.getNome());
        setorRepository.save(setor);
    }

    private SetorDTO convertToDTO(SetorModel setor) {
        return new SetorDTO(
            setor.getId(),
            setor.getNome(),
            setor.getFuncionarios().stream().map(funcionario -> funcionario.getId()).collect(Collectors.toList())
        );
    }
}