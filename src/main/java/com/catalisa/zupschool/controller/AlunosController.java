package com.catalisa.zupschool.controller;

import com.catalisa.zupschool.dto.AlunoDTO;
import com.catalisa.zupschool.model.AlunoModel;
import com.catalisa.zupschool.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    AlunosService alunosService;

    //Exibindo lista de alunos
    @GetMapping
    public List<AlunoDTO> listarAlunos(){
        List<AlunoModel> alunos = alunosService.buscarTodos();
        List<AlunoDTO> alunosDTO = new ArrayList<>();

        for (AlunoModel alunoModel : alunos) {
            AlunoDTO dto = new AlunoDTO();

            dto.setNome(alunoModel.getNome());
            dto.setEmail(alunoModel.getEmail());
            alunosDTO.add(dto);
        }
        return alunosDTO;
    }

    //Cadastrando novos alunos
    @PostMapping
    public AlunoModel cadastrarAluno (@RequestBody AlunoModel alunoModel){
        return alunosService.cadastrar(alunoModel);
    }

    //Deletando um aluno por ID
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        alunosService.deletar(id);
    }

}
