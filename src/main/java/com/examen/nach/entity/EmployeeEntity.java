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
    private Integer employeeId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "job_id",nullable = false)
    private Integer jobId;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "birthdate",nullable = false)
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name="gender_id",insertable = false,updatable = false)
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name="job_id",insertable = false,updatable = false)
    private JobEntity job;

    @OneToMany(mappedBy="employee_worked_hour")
    private List<EmployeeWorkedHourEntity> employeeWorkedHour;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
