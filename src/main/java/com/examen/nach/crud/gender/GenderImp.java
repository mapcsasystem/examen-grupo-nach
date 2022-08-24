package com.examen.nach.crud.gender;

import com.examen.nach.entity.Gender;
import com.examen.nach.service.GenderService;

import java.util.List;
import java.util.Optional;

public class GenderImp implements IGenderImp {
    GenderService genderService;

    public GenderImp(GenderService genderService) {
        this.genderService = genderService;
    }

    @Override
    public List<Gender> getAllGender() {
        return genderService.getAllGender();
    }

    @Override
    public Optional<Gender> getByIdGender(long id) {
        return genderService.getByIdGender(id);
    }
}
