package com.examen.nach.controller;
import com.examen.nach.crud.gender.IGenderImp;
import com.examen.nach.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gender")
public class GenderResController {

    @Autowired
    private final IGenderImp genderImp;

    public GenderResController(IGenderImp genderImp) {
        this.genderImp = genderImp;
    }

    @GetMapping("/get-all")
    List<Gender> getAllEmployees() {
        return genderImp.getAllGender();
    }

    @PostMapping(value = "/create")
    ResponseEntity<Map<String, String>> saveEmployee(@RequestBody Gender gender) {
        Map<String, String> map = new HashMap<>();
        if (gender.getName().isEmpty()) {
            map.put("id", "null 1");
            map.put("success", "false");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        Gender auxGender = genderImp.createGender(gender);
        map.put("id", auxGender.getGenderId().toString());
        map.put("success", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}