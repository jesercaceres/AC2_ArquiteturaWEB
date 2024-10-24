package com.ac2.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private Integer setorId;
    private List<Integer> projetoIds;
}