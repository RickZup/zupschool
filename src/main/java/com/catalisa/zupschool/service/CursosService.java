package com.catalisa.zupschool.service;

import com.catalisa.zupschool.model.AlunoModel;
import com.catalisa.zupschool.model.CursoModel;
import com.catalisa.zupschool.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {

    @Autowired
    CursosRepository cursosRepository;

    public List<CursoModel> buscarTodos(){
        return cursosRepository.findAll();
    }

    public CursoModel cadastrar(CursoModel cursoModel){
        return cursosRepository.save(cursoModel);
    }

    public void deletar(Long id){
        cursosRepository.deleteById(id);
    }
}
