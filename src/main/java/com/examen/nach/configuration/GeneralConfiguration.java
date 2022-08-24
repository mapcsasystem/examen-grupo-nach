package com.examen.nach.configuration;


import com.examen.nach.crud.employee.EmployeeImp;
import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.crud.employee_worked_hours.EmployeeWorkedHourImp;
import com.examen.nach.crud.employee_worked_hours.IEmployeeWorkedHourImp;
import com.examen.nach.crud.gender.GenderImp;
import com.examen.nach.crud.gender.IGenderImp;
import com.examen.nach.crud.job.IJobImp;
import com.examen.nach.crud.job.JobImp;
import com.examen.nach.service.EmployeeService;
import com.examen.nach.service.EmployeeWorkedHourService;
import com.examen.nach.service.GenderService;
import com.examen.nach.service.JobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
   @Bean
    IEmployeesImp employee(EmployeeService employeeService){
        return new EmployeeImp(employeeService);
    }

    @Bean
    IEmployeeWorkedHourImp employeeWorkedHour(EmployeeWorkedHourService employeeWorkedHourService){
        return new EmployeeWorkedHourImp(employeeWorkedHourService);
    }

    @Bean
    IGenderImp gender(GenderService genderService){
        return new GenderImp(genderService);
    }

    @Bean
    IJobImp job(JobService jobService){
        return new JobImp(jobService);
    }
}
