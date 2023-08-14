package com.catalisa.zupschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_ALUNOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;
    private String nome;
    private int idade;
    private String email;

}
