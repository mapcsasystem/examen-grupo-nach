package com.examen.nach.entity;

import javax.persistence.*;

@Entity
@Table(name="jobs")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id",nullable = false, unique = true)
    private Integer jobId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "salary",nullable = false)
    private Double salary;

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
