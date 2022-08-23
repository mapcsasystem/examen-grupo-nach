package com.examen.nach.configuration;


import com.examen.nach.crud.employee.EmployeeImp;
import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Bean
    IEmployeesImp employee(EmployeeService employeeService){
        return new EmployeeImp(employeeService);
    }
}
