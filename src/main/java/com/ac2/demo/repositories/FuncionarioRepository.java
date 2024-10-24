package com.ac2.demo.repositories;

import com.ac2.demo.model.FuncionarioModel;
import com.ac2.demo.model.ProjetoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {

    @Query("SELECT f.projetos FROM FuncionarioModel f WHERE f.id = :id")
    List<ProjetoModel> findProjetosByFuncionarioId(@Param("id") Integer id);
}
