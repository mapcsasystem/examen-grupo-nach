package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employyee_id",nullable = false,unique = true)
    private Integer employyeeId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "gender-id",nullable = false)
    private Integer genderId;

    @Column(name = "job-id",nullable = false)
    private Integer jobId;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "birthdate",nullable = false)
    private LocalDate birthdate;



    public Integer getEmployyeeId() {
        return employyeeId;
    }

    public void setEmployyeeId(Integer employyeeId) {
        this.employyeeId = employyeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
