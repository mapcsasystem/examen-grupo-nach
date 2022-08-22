package com.examen.nach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jobs")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false, unique = true)
    private Integer jobId;
    private String name;
    private Double salary;

    @OneToMany(mappedBy="job")
    private List<EmployeeEntity> employees;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
