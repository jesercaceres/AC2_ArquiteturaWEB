package com.ac2.demo.repositories;

import com.ac2.demo.model.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

//conferido ok.
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Integer> {

    @Query("SELECT p FROM ProjetoModel p JOIN FETCH p.funcionarios WHERE p.id = :id")
    ProjetoModel findProjetoWithFuncionarios(@Param("id") Integer id);

    @Query("SELECT p FROM ProjetoModel p WHERE p.dataInicio BETWEEN :startDate AND :endDate")
    List<ProjetoModel> findProjetosByDataInicioBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
