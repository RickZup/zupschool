package com.catalisa.zupschool.controller;

import com.catalisa.zupschool.dto.ProfessorDTO;
import com.catalisa.zupschool.model.ProfessorModel;
import com.catalisa.zupschool.service.ProfessoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessoresController {

    @Autowired
    ProfessoresService professoresService;

    @GetMapping
    public List<ProfessorDTO> listarProfessores(){
        List<ProfessorModel> professores = professoresService.buscartodos();
        List<ProfessorDTO> professoresDTO = new ArrayList<>();

        for (ProfessorModel professorModel : professores) {
            ProfessorDTO dto = new ProfessorDTO();

            dto.setNome(professorModel.getNome());
            dto.setCursoModel(professorModel.getCurso());
            professoresDTO.add(dto);
        }
        return professoresDTO;
    }

    @PostMapping
    public ProfessorModel cadastrarProfessor(@RequestBody ProfessorModel professorModel){
        return professoresService.cadastrar(professorModel);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id){
        professoresService.deletar(id);
    }

}
