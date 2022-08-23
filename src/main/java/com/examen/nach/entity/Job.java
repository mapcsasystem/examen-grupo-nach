package com.examen.nach.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false, unique = true)
    private Long jobId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "salary", nullable = false)
    private Double salary;

    @OneToMany(mappedBy = "jobs",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Employee> employees=new ArrayList<>();

    public Job() {
    }

    public Job(String name, Double salary, List<Employee> employees) {
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
