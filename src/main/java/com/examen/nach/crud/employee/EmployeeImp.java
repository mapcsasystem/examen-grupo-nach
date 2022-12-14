package com.examen.nach.crud.employee;

import com.examen.nach.entity.Employee;
import com.examen.nach.service.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeImp implements IEmployeesImp{
    EmployeeService employeeService;

    public EmployeeImp(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    public Optional<Employee> getByIdEmployee(long id) {
        return employeeService.getByIdEmployee(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @Override
    public List<Employee> findByNameAndLastName(String name, String lastName) {
        return employeeService.findByNameAndLastName(name, lastName);
    }

    @Override
    public List<Employee> findByJobId(Long jobId) {
        return employeeService.findByJobId(jobId);
    }
}
