package com.examen.nach.crud.employee;

import com.examen.nach.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeesImp {
    List<Employee> getAllEmployees();
    Optional<Employee> getByIdEmployee(long id);
    Optional<Employee> createEmployee(Employee employee);
}
