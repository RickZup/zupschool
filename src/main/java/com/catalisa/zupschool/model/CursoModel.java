package com.catalisa.zupschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "TB_CURSOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    private String nome;
    private int cargaHoraria;
}
