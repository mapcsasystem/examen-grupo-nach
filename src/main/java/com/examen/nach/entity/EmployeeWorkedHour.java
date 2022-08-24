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
    private String employeeId;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name="employee_id",insertable = false,updatable = false)
    private Employee employees;

    public EmployeeWorkedHour() {
    }

    public EmployeeWorkedHour(Long idEmployeeWorkedHour, String name, String employeeId, Double salary, Employee employees) {
        this.idEmployeeWorkedHour = idEmployeeWorkedHour;
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
                "idEmployeeWorkedHour=" + idEmployeeWorkedHour +
                ", name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", salary=" + salary +
                ", employees=" + employees +
                '}';
    }
}
