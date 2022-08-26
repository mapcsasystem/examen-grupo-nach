package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name="gender_id",insertable = false,updatable = false)
    private Gender genders;

    @Column(name = "gender_id")
    private Long genderId;

    @Column(name = "job_id")
    private Long jobId;

    @ManyToOne
    @JoinColumn(name="job_id",insertable = false,updatable = false)
    private Job jobs;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    public Employee() {
    }

    public Employee(Gender genders, Long genderId, Long jobId, Job jobs, String name, String lastName, LocalDate birthdate) {
        this.genders = genders;
        this.genderId = genderId;
        this.jobId = jobId;
        this.jobs = jobs;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Gender getGenders() {
        return genders;
    }

    public void setGenders(Gender genders) {
        this.genders = genders;
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

    public Job getJobs() {
        return jobs;
    }

    public void setJobs(Job jobs) {
        this.jobs = jobs;
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", genders=" + genders +
                ", genderId=" + genderId +
                ", jobId=" + jobId +
                ", jobs=" + jobs +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
