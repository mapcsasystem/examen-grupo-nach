package com.examen.nach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genders")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id",nullable = false,  unique = true)
    private Long genderId;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getGenderId() {
        return genderId;
    }

    @OneToMany(mappedBy = "genders")
    private List<EmployeeEntity> employees;

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
