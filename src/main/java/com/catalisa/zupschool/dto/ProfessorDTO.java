package com.catalisa.zupschool.dto;

import com.catalisa.zupschool.model.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private String nome;
    private CursoModel cursoModel;

}
