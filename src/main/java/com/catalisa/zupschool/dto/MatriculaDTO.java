package com.catalisa.zupschool.dto;

import com.catalisa.zupschool.model.AlunoModel;
import com.catalisa.zupschool.model.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private String dataMatricula;
    private AlunoModel alunoModel;
    private CursoModel cursoModel;

}
