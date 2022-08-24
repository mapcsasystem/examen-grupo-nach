package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    private String name;

    @Column(name = "gender_id")
    private Long genderId;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name="job_id",insertable = false,updatable = false)
    private Job jobs;

    @ManyToOne
    @JoinColumn(name="gender_id",insertable = false,updatable = false)
    private Gender genders;

    @OneToMany(mappedBy = "employees")
    private List<EmployeeWorkedHour> employeeWorkedHour;



    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<EmployeeWorkedHour> getEmployeeWorkedHour() {
        return employeeWorkedHour;
    }

    public void setEmployeeWorkedHour(List<EmployeeWorkedHour> employeeWorkedHour) {
        this.employeeWorkedHour = employeeWorkedHour;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", genderId=" + genderId +
                ", jobId=" + jobId +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", jobs=" + jobs +
                ", genders=" + genders +
                ", employeeWorkedHour=" + employeeWorkedHour +
                '}';
    }
}
