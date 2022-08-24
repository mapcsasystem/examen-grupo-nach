package com.examen.nach.service;

import com.examen.nach.entity.Gender;
import com.examen.nach.repository.GenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    private GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> getAllGender(){
        return genderRepository.findAll();
    }

    public Optional<Gender> getByIdGender(long id){
        return genderRepository.findById(id);
    }

    public Gender createGender(Gender gender){
        return genderRepository.save(gender);
    }
}
