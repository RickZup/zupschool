package com.catalisa.zupschool.service;

import com.catalisa.zupschool.model.ProfessorModel;
import com.catalisa.zupschool.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessoresService {

    @Autowired
    ProfessoresRepository professoresRepository;

    public List<ProfessorModel> buscartodos(){
        return professoresRepository.findAll();
    }

    public ProfessorModel cadastrar(ProfessorModel professorModel){
        return professoresRepository.save(professorModel);
    }

    public void deletar(Long id){
        professoresRepository.deleteById(id);
    }

}
