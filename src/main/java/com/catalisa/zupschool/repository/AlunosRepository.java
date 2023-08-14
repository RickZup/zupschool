package com.catalisa.zupschool.repository;

import com.catalisa.zupschool.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<AlunoModel, Long> {
}
