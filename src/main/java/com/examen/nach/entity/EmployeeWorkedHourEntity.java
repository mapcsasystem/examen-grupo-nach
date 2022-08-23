package com.examen.nach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_worked_hour_id", nullable = false, unique = true)
    private Long employeeWorkedHourId;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false,updatable = true)
    private EmployeeWorkedHourEntity employeeWorkedHours;

    public Long getEmployeeWorkedHourId() {
        return employeeWorkedHourId;
    }

    public void setEmployeeWorkedHourId(Long employeeWorkedHourId) {
        this.employeeWorkedHourId = employeeWorkedHourId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
