package com.catalisa.zupschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_PROFESSORES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

    private String nome;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private CursoModel curso;

    private double salario;

}
