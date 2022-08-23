package com.examen.nach.controller;

import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResController {
    private IEmployeesImp employeesImp;

    public EmployeeResController(IEmployeesImp employeesImp) {
        this.employeesImp = employeesImp;
    }

    @GetMapping("/get-all")
    List<Employee> getAllEmployees() {
        return employeesImp.getAllEmployees();
    }

}
