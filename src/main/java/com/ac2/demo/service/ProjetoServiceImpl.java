package com.ac2.demo.service;

import com.ac2.demo.dto.ProjetoDTO;
import com.ac2.demo.model.FuncionarioModel;
import com.ac2.demo.model.ProjetoModel;
import com.ac2.demo.repositories.FuncionarioRepository;
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

    @Autowired
    private FuncionarioRepository funcionarioRepository;

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

    @Override
    public void adicionarProjeto(ProjetoDTO projetoDTO) {
        // Verificar se todos os IDs de funcionários existem
        List<Integer> funcionarioIds = projetoDTO.getFuncionarioIds();
        if (funcionarioIds != null && !funcionarioIds.isEmpty()) {
            long count = funcionarioRepository.countByIdIn(funcionarioIds);
            if (count != funcionarioIds.size()) {
                throw new RuntimeException("Um ou mais IDs de funcionários são inválidos.");
            }
        }

        ProjetoModel projeto = new ProjetoModel();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

        // Associar funcionários ao projeto
        if (funcionarioIds != null && !funcionarioIds.isEmpty()) {
            List<FuncionarioModel> funcionarios = funcionarioRepository.findAllById(funcionarioIds);
            projeto.setFuncionarios(funcionarios);
        }

        projetoRepository.save(projeto);
    }

    private ProjetoDTO convertToDTO(ProjetoModel projeto) {
        return new ProjetoDTO(
            projeto.getId(),  // Certifique-se de que o ID do projeto está sendo passado aqui
            projeto.getDescricao(),
            projeto.getDataInicio(),
            projeto.getDataFim(),
            projeto.getFuncionarios().stream().map(FuncionarioModel::getId).collect(Collectors.toList())
        );
    }
}