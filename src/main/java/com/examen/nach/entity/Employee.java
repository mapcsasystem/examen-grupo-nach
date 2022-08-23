package com.examen.nach.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",nullable = false, unique = true)
    private Long employeeId;

    @Column(name = "gender_id" , nullable = false)
    private Long genderId;

    @Column(name = "job_id",nullable = false)
    private Long jobId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "birthdate",nullable = false)
    private LocalDate birthdate;

    @ManyToOne
    private Job jobs;

    @ManyToOne
    private Gender genders;

    @OneToMany(mappedBy = "employees",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    @Column(name = "employee_worked_hours")
    private List<EmployeeWorkedHour> employeeWorkedHours=new ArrayList<>();

    public Employee() {
    }

    public Employee(Long genderId, Long jobId, String name, String lastName, LocalDate birthdate, Job jobs, Gender genders, List<EmployeeWorkedHour> employeeWorkedHours) {
        this.genderId = genderId;
        this.jobId = jobId;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.jobs = jobs;
        this.genders = genders;
        this.employeeWorkedHours = employeeWorkedHours;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Job getJobs() {
        return jobs;
    }

    public void setJobs(Job jobs) {
        this.jobs = jobs;
    }

    public Gender getGenders() {
        return genders;
    }

    public void setGenders(Gender genders) {
        this.genders = genders;
    }

    public List<EmployeeWorkedHour> getEmployeeWorkedHours() {
        return employeeWorkedHours;
    }

    public void setEmployeeWorkedHours(List<EmployeeWorkedHour> employeeWorkedHours) {
        this.employeeWorkedHours = employeeWorkedHours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", genderId=" + genderId +
                ", jobId=" + jobId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", jobs=" + jobs +
                ", genders=" + genders +
                ", employeeWorkedHours=" + employeeWorkedHours +
                '}';
    }
}
