package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_worked_hour_id")
    private Long idEmployeeWorkedHour;

    @Column(name = "name")
    private String name;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "worker_hours")
    private Integer workedHours;

    @Column(name = "worker_date")
    private LocalDate workedDate;

    @ManyToOne
    @JoinColumn(name="employee_id",insertable = false,updatable = false)
    private Employee employees;

    public EmployeeWorkedHour() {
    }

    public EmployeeWorkedHour(Long idEmployeeWorkedHour, String name, Long employeeId, Integer workedHours, LocalDate workedDate, Employee employees) {
        this.idEmployeeWorkedHour = idEmployeeWorkedHour;
        this.name = name;
        this.employeeId = employeeId;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
        this.employees = employees;
    }

    public Long getIdEmployeeWorkedHour() {
        return idEmployeeWorkedHour;
    }

    public void setIdEmployeeWorkedHour(Long idEmployeeWorkedHour) {
        this.idEmployeeWorkedHour = idEmployeeWorkedHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeeWorkedHour{" +
                "idEmployeeWorkedHour=" + idEmployeeWorkedHour +
                ", name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", workedHours=" + workedHours +
                ", workedDate=" + workedDate +
                ", employees=" + employees +
                '}';
    }
}
