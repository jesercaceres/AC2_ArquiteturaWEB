package com.ac2.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetorDTO {
    private Integer id;
    private String nome;
    private List<Integer> funcionarioIds;
}
