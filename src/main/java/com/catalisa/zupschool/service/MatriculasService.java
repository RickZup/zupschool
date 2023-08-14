package com.catalisa.zupschool.service;

import com.catalisa.zupschool.model.CursoModel;
import com.catalisa.zupschool.model.MatriculaModel;
import com.catalisa.zupschool.repository.MatriculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculasService {

    @Autowired
    MatriculasRepository matriculasRepository;

    public List<MatriculaModel> buscarTodos(){
        return matriculasRepository.findAll();
    }

    public MatriculaModel cadastrar(MatriculaModel matriculaModel){
        return matriculasRepository.save(matriculaModel);
    }

    public MatriculaModel alterarCurso(Long id, CursoModel novoCurso) {
        Optional<MatriculaModel> matriculaOptional = matriculasRepository.findById(id);
        if (matriculaOptional.isPresent()) {
            MatriculaModel matricula = matriculaOptional.get();
            matricula.setCurso(novoCurso);
            return matriculasRepository.save(matricula);
        }
        return null;
    }

    public void deletar(Long id){
        matriculasRepository.deleteById(id);
    }

}
