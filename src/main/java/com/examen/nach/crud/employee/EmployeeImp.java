package com.examen.nach.crud.employee;

import com.examen.nach.entity.Employee;
import com.examen.nach.service.EmployeeService;

import java.util.List;

public class EmployeeImp implements IEmployeesImp{
    EmployeeService employeeService;

    public EmployeeImp(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
