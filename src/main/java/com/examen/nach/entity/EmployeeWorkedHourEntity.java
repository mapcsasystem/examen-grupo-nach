package com.examen.nach.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_worked_hour_id",nullable = false,unique = true)
    private Integer employeeWorkedHourId;

    @Column(name = "employyee_id",nullable = false)
    private Integer employyeeId;

    @Column(name = "worked_hours",nullable = false)
    private Integer workedHours;

    @Column(name = "worked_date",nullable = false)
    private LocalDate workedDate;

    public Integer getEmployeeWorkedHourId() {
        return employeeWorkedHourId;
    }

    public void setEmployeeWorkedHourId(Integer employeeWorkedHourId) {
        this.employeeWorkedHourId = employeeWorkedHourId;
    }

    public Integer getEmployyeeId() {
        return employyeeId;
    }

    public void setEmployyeeId(Integer employyeeId) {
        this.employyeeId = employyeeId;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(LocalDate workedDate) {
        this.workedDate = workedDate;
    }
}
