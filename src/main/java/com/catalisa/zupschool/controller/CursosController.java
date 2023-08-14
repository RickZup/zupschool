package com.catalisa.zupschool.controller;

import com.catalisa.zupschool.dto.CursoDTO;
import com.catalisa.zupschool.model.CursoModel;
import com.catalisa.zupschool.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    CursosService cursosService;

    @GetMapping
    public List<CursoDTO> listarCursos(){
        List<CursoModel> cursos = cursosService.buscarTodos();
        List<CursoDTO> cursosDTO = new ArrayList<>();

        for (CursoModel cursoModel : cursos) {
            CursoDTO dto = new CursoDTO();

            dto.setNome(cursoModel.getNome());
            dto.setCargaHoraria(cursoModel.getCargaHoraria());
            cursosDTO.add(dto);
        }
        return cursosDTO;
    }

    @PostMapping
    public CursoModel cadastrarCurso(@RequestBody CursoModel cursoModel){
        return cursosService.cadastrar(cursoModel);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable Long id){
        cursosService.deletar(id);
    }

}
