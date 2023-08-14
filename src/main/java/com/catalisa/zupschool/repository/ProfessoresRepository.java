package com.catalisa.zupschool.repository;

import com.catalisa.zupschool.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessoresRepository extends JpaRepository<ProfessorModel, Long> {
}
