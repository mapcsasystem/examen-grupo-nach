package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",nullable = false, unique = true)
    private Long employeeId;

    @Column(name = "gender_id" , nullable = false)
    private Integer genderId;

    @Column(name = "job_id",nullable = false)
    private Integer jobId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "birthdate",nullable = false)
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "gender_id", insertable = false,updatable = true)
    private GenderEntity genders;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false,updatable = true)
    private JobEntity jobs;

    @OneToMany(mappedBy = "employeeWorkedHours")
    private List<EmployeeWorkedHourEntity> employeeWorkedHours;
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
}
