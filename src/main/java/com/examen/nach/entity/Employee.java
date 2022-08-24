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

    @Column(name = "id_gender")
    private Long idGender;

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

    @OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
    private List<EmployeeWorkedHour> employeeWorkedHour;

    public Employee() {
    }

    public Employee(Long employeeId, String name, Long idGender, Long jobId, String lastName, LocalDate birthdate, Job jobs, Gender genders, List<EmployeeWorkedHour> employeeWorkedHour) {
        this.employeeId = employeeId;
        this.name = name;
        this.idGender = idGender;
        this.jobId = jobId;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.jobs = jobs;
        this.genders = genders;
        this.employeeWorkedHour = employeeWorkedHour;
    }

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

    public Long getIdGender() {
        return idGender;
    }

    public void setIdGender(Long idGender) {
        this.idGender = idGender;
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
                ", idGender=" + idGender +
                ", jobId=" + jobId +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", jobs=" + jobs +
                ", genders=" + genders +
                ", employeeWorkedHour=" + employeeWorkedHour +
                '}';
    }
}
