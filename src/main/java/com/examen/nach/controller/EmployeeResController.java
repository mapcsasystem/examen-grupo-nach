package com.examen.nach.controller;

import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.crud.gender.IGenderImp;
import com.examen.nach.crud.job.IJobImp;
import com.examen.nach.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResController {
    @Autowired
    private final IEmployeesImp employeesImp;
    @Autowired
    private final IJobImp jobImp;
    @Autowired
    private final IGenderImp genderImp;

    public EmployeeResController(IEmployeesImp employeesImp, IJobImp jobImp, IGenderImp genderImp) {
        this.employeesImp = employeesImp;
        this.jobImp = jobImp;
        this.genderImp = genderImp;
    }
    @GetMapping("/get-all")
    List<Employee> getAllEmployees() {
        return employeesImp.getAllEmployees();
    }

    @GetMapping("/get-by-id/{id}")
    Map<String, String> getByIdEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee=employeesImp.getByIdEmployee(id);
        Map<String,String> map=new HashMap<>();
        if(employee.isPresent()){
            map.put("sucess","true");
            map.put("id",employee.toString());
            return map;
        }else{
            map.put("sucess","true");
            map.put("id","null");
            return map;
        }
    }

    @PostMapping(value = "/create")
    ResponseEntity<Map<String, String>>saveEmployee(@RequestBody Employee employee){
        Map<String,String> map=new HashMap<>();

        long age = LocalDate.from(employee.getBirthdate()).until(LocalDate.now(), ChronoUnit.YEARS);
        if (age <= 18) {
            map.put("id", "null" + "18");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
       if (jobImp.getByIdJob(employee.getJobId()).isEmpty()) {
           map.put("id", "null"+ "joBID");
           map.put("success", "false");
           return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        if (genderImp.getByIdGender(employee.getJobId()).isEmpty()) {
            map.put("id", "null"+ "genderID");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        if (employeesImp.findByNameAndLastName(employee.getName(), employee.getLastName()).isEmpty()) {
            map.put("id", "null"+ "Name and lastName");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        Employee empl=employeesImp.createEmployee(employee);
        map.put("id", empl.getEmployeeId().toString());
        map.put("success", "true");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }

}
