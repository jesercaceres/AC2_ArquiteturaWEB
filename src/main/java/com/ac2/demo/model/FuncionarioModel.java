package com.ac2.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nome_Funcionario", length = 100, nullable = false)
    private String nome;

    // Vários funcionários associados a um único setor.
    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private SetorModel setor;

    @ManyToMany
    // Especifica a tabela de junção para a relação muitos-para-muitos.
    @JoinTable(name = "funcionario_projeto",
            // Define a coluna que referencia FuncionarioModel.
            joinColumns = @JoinColumn(name = "funcionario_id"),
            // Define a coluna que referencia ProjetoModel.
            inverseJoinColumns = @JoinColumn(name = "projeto_id"))
    private List<ProjetoModel> projetos;

    public FuncionarioModel(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "FuncionarioModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}