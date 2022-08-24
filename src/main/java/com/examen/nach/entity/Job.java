package com.examen.nach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;
    private String name;
    private Double salary;

    @OneToMany(mappedBy = "jobs")
    private List<Employee> employees;

    public Job() {
    }

    public Job(Long jobId, String name, Double salary, List<Employee> employees) {
        this.jobId = jobId;
        this.name = name;
        this.salary = salary;
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", employees=" + employees +
                '}';
    }
}
