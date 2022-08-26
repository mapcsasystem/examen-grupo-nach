package com.examen.nach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long jobId;
    private String name;
    private Double salary;

    public Job() {
    }

    public Job(String name, Double salary) {
        this.name = name;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
