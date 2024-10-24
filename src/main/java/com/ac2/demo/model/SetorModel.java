package com.ac2.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    // Um setor associado a vários Funcionários.
    // MappedBy indica que setor vai ter uma FK dentro de Funcionários.
    @OneToMany(mappedBy = "setor")
    private List<FuncionarioModel> funcionarios;

    @Override
    public String toString() {
        return "SetorModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}