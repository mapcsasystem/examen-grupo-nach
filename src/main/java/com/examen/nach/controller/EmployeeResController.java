package com.examen.nach.controller;

import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.crud.gender.IGenderImp;
import com.examen.nach.crud.job.IJobImp;
import com.examen.nach.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResController {
    private IEmployeesImp employeesImp;
    private IJobImp iJobImp;
    private IGenderImp iGenderImp;

    public EmployeeResController(IEmployeesImp employeesImp, IJobImp iJobImp, IGenderImp iGenderImp) {
        this.employeesImp = employeesImp;
        this.iJobImp = iJobImp;
        this.iGenderImp = iGenderImp;
    }

    public EmployeeResController(IEmployeesImp employeesImp) {
        this.employeesImp = employeesImp;
    }

    @GetMapping("/get-all")
    List<Employee> getAllEmployees() {
        return employeesImp.getAllEmployees();
    }

    @GetMapping("/get-by-id/{id}")
    Map<String, String> getByIdEmployee(@PathVariable long id) {
        Optional<Employee> employee=employeesImp.getByIdEmployee(id);
        Map<String,String> map=new HashMap<>();
        if(employee.isPresent()){
            map.put("Sucess","true");
            map.put("id",employee.toString());
            return map;
        }else{
            map.put("Sucess","true");
            map.put("id","null");
            return map;
        }
    }

    @PostMapping("/create")
    public  Map<String, String>  saveEmployee(@RequestBody Employee employee){
        Map<String,String> map=new HashMap<>();
        iJobImp.getByIdJob(employee.getJobId());
       if (!iJobImp.getByIdJob(employee.getJobId())) {
            map.put("id", "null");
            map.put("success", "false");
            return map;
        }
        if (!iGenderImp.getByIdGender(employee.getJobId())) {
            map.put("id", "null");
            map.put("success", "false");
            return map;
        }
        long age = LocalDate.from(employeeRequest.getBirthdate()).until(LocalDate.now(), ChronoUnit.YEARS);
        if (age <= 18) {
            objectNode.put("id", (String) null);
            objectNode.put("success", false);
            return objectNode;
        }

        if (employeeRepository.findByNameAndLastName(employeeRequest.getName(), employeeRequest.getLastName()).isPresent()) {
            objectNode.put("id", (String) null);
            objectNode.put("success", false);
            return objectNode;
        }
        return map;
    }

}
