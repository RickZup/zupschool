package com.catalisa.zupschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_MATRICULAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricula;

    private String dataMatricula;

    @OneToOne
    @JoinColumn(name = "id_aluno")
    private AlunoModel aluno;

    @OneToOne
    @JoinColumn(name = "id_curso")
    private CursoModel curso;

}
