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
import java.util.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResController {
    @Autowired
    private  IEmployeesImp employeesImp;
    @Autowired
    private  IJobImp jobImp;
    @Autowired
    private  IGenderImp genderImp;


    @GetMapping("/get-all")
    ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeesImp.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    Map<String, String> getByIdEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee=employeesImp.getByIdEmployee(id);
        Map<String,String> map=new HashMap<>();
        if(employee.isPresent()){
            map.put("sucess","true");
            map.put("id",""+id);
            return map;
        }else{
            map.put("sucess","false");
            map.put("id","null");
            return map;
        }
    }

    @GetMapping(value = "/get-by-job-id")
    @ResponseBody
    ResponseEntity<Map<String, Object>> getEmployeeByJobId(@RequestParam("job_id") long id){
        Map<String,Object> map=new HashMap<>();
        if (!jobImp.jobExists(id)) {
            map.put("employees", new ArrayList());
            map.put("success", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        List<Employee> employee=employeesImp.findByJobId(id);
        map.put("employees", employee);
        map.put("success", true);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    ResponseEntity<Map<String, Object>>saveEmployee(@RequestBody Employee employee){
        Map<String,Object> map=new HashMap<>();
        long age = LocalDate.from(employee.getBirthdate()).until(LocalDate.now(), ChronoUnit.YEARS);
        if (age <= 18) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
       if (jobImp.getByIdJob(employee.getJobId()).isEmpty()) {
           map.put("id", null );
           map.put("success", false);
           return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        if (genderImp.getByIdGender(employee.getGenderId()).isEmpty()) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        if (!employeesImp.findByNameAndLastName(employee.getName(), employee.getLastName()).isEmpty()) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        Employee empl=employeesImp.createEmployee(employee);
        map.put("id", empl.getEmployeeId().toString());
        map.put("success", true);
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }



}
