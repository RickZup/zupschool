package com.catalisa.zupschool.repository;

import com.catalisa.zupschool.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<CursoModel, Long> {
}
