package com.examen.nach.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "employee_worked_hour_id", nullable = false, unique = true)
    private Long employeeWorkedHourId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @ManyToOne
    private Employee employees;

    public EmployeeWorkedHour() {
    }

    public EmployeeWorkedHour(String name, Double salary, Employee employees) {
        this.name = name;
        this.salary = salary;
        this.employees = employees;
    }

    public Long getEmployeeWorkedHourId() {
        return employeeWorkedHourId;
    }

    public void setEmployeeWorkedHourId(Long employeeWorkedHourId) {
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

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeeWorkedHour{" +
                "employeeWorkedHourId=" + employeeWorkedHourId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", employees=" + employees +
                '}';
    }
}
