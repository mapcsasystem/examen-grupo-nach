package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeWorkedHourId;

    @Column(name ="employee_id")
    private Long employeeId;

    @Column(name = "worked_hours")
    private Integer workedHours;

    @Column(name = "worked_date")
    private LocalDate workedDate;

    public EmployeeWorkedHour() {
    }

    public EmployeeWorkedHour(Long employeeId, Integer workedHours, LocalDate workedDate) {
        this.employeeId = employeeId;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }

    public Long getEmployeeWorkedHourId() {
        return employeeWorkedHourId;
    }

    public void setEmployeeWorkedHourId(Long employeeWorkedHourId) {
        this.employeeWorkedHourId = employeeWorkedHourId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public String toString() {
        return "EmployeeWorkedHour{" +
                "employeeWorkedHourId=" + employeeWorkedHourId +
                ", employeeId=" + employeeId +
                ", workedHours=" + workedHours +
                ", workedDate=" + workedDate +
                '}';
    }
}
