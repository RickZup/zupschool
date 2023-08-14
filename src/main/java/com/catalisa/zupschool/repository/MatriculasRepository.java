package com.catalisa.zupschool.repository;

import com.catalisa.zupschool.model.MatriculaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculasRepository extends JpaRepository<MatriculaModel, Long> {
}
