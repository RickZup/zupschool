package com.catalisa.zupschool.controller;

import com.catalisa.zupschool.model.CursoModel;
import com.catalisa.zupschool.model.MatriculaModel;
import com.catalisa.zupschool.service.MatriculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    MatriculasService matriculaService;

    // Cadastrar Matrícula
    @PostMapping
    public MatriculaModel cadastrarMatricula(@RequestBody MatriculaModel matricula) {
        return matriculaService.cadastrar(matricula);
    }

    // Alterar Curso de Matrícula
    @PutMapping("/{matriculaId}")
    public MatriculaModel alterarCursoMatricula(@PathVariable Long matriculaId, @RequestBody CursoModel novoCurso) {
        return matriculaService.alterarCurso(matriculaId, novoCurso);
    }

    // Buscar todas as Matrículas
    @GetMapping
    public List<MatriculaModel> buscarMatriculas() {
        return matriculaService.buscarTodos();
    }

    // Deletar Matrícula
    @DeleteMapping("/{matriculaId}")
    public void deletarMatricula(@PathVariable Long matriculaId) {
        matriculaService.deletar(matriculaId);
    }
}

