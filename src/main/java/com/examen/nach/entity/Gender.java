package com.examen.nach.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id",nullable = false,  unique = true)
    private Long genderId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "genders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Employee> employees=new ArrayList<>();

    public Gender() {
    }

    public Gender(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId=" + genderId +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}