package com.examen.nach.crud.gender;


import com.examen.nach.entity.Gender;
import com.examen.nach.entity.Job;

import java.util.List;
import java.util.Optional;

public interface IGenderImp {
    List<Gender> getAllGender();
    Optional<Gender> getByIdGender(long id);
    Gender createGender(Gender gender);
}
