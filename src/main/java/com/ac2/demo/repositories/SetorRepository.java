package com.ac2.demo.repositories;

import com.ac2.demo.model.SetorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SetorRepository extends JpaRepository<SetorModel, Integer> {

    @Query("SELECT s FROM SetorModel s JOIN FETCH s.funcionarios")
    List<SetorModel> findAllWithFuncionarios();
}
    