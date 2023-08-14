package com.catalisa.zupschool.service;

import com.catalisa.zupschool.model.AlunoModel;
import com.catalisa.zupschool.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    AlunosRepository alunosRepository;

    public List<AlunoModel> buscarTodos(){
        return alunosRepository.findAll();
    }

    public AlunoModel cadastrar(AlunoModel alunoModel){
        return alunosRepository.save(alunoModel);
    }

    public void deletar(Long id){
        alunosRepository.deleteById(id);
    }

}
