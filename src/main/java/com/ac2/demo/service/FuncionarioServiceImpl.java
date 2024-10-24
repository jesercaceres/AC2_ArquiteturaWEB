package com.ac2.demo.service;

import com.ac2.demo.dto.FuncionarioDTO;
import com.ac2.demo.dto.ProjetoDTO;
import com.ac2.demo.model.FuncionarioModel;
import com.ac2.demo.model.ProjetoModel;
import com.ac2.demo.model.SetorModel;
import com.ac2.demo.repositories.SetorRepository;
import com.ac2.demo.repositories.FuncionarioRepository;
import com.ac2.demo.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private SetorRepository setorRepository; 

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public List<ProjetoDTO> getProjetosByFuncionarioId(Integer id) {
        List<ProjetoModel> projetos = funcionarioRepository.findProjetosByFuncionarioId(id);
        return projetos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public void adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(funcionarioDTO.getNome());

        SetorModel setor = setorRepository.findById(funcionarioDTO.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        funcionario.setSetor(setor);

        // Verificar se todos os IDs de projetos existem
        List<Integer> projetoIds = funcionarioDTO.getProjetoIds();
        if (projetoIds != null && !projetoIds.isEmpty()) {
            long count = projetoRepository.countByIdIn(projetoIds);
            if (count != projetoIds.size()) {
                throw new RuntimeException("Um ou mais IDs de projetos são inválidos.");
            }
            List<ProjetoModel> projetos = projetoRepository.findAllById(projetoIds);
            funcionario.setProjetos(projetos);
        }

        funcionarioRepository.save(funcionario);
    }

    private ProjetoDTO convertToDTO(ProjetoModel projeto) {
        return new ProjetoDTO(
                projeto.getId(),
                projeto.getDescricao(),
                projeto.getDataInicio(),
                projeto.getDataFim(),
                projeto.getFuncionarios().stream().map(FuncionarioModel::getId).collect(Collectors.toList()));
    }
}