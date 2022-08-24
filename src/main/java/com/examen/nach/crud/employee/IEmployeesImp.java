package com.examen.nach.crud.employee;

import com.examen.nach.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeesImp {
    List<Employee> getAllEmployees();
    Optional<Employee> getByIdEmployee(long id);
    Employee createEmployee(Employee employee);

    List<Employee> findByNameAndLastName(String name, String lastName);
    List<Employee> findByJobId(Long jobId);
}
