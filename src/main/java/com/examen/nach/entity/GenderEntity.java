package com.examen.nach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genders")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id",nullable = false,  unique = true)
    private Integer genderId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy="gender")
    private List<EmployeeEntity> employees;

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
