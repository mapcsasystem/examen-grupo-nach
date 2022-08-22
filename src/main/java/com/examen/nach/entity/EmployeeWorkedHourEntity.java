package com.examen.nach.entity;

import javax.persistence.*;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_worked_hour_id", nullable = false, unique = true)
    private Integer employeeWorkedHourId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name="employee_worked_hour_id",insertable = false,updatable = false)
    private EmployeeEntity employee_worked_hour;

    public Integer getEmployeeWorkedHourId() {
        return employeeWorkedHourId;
    }

    public void setEmployeeWorkedHourId(Integer employeeWorkedHourId) {
        this.employeeWorkedHourId = employeeWorkedHourId;
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
