package com.examen.nach.controller;

import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.crud.employee_worked_hours.IEmployeeWorkedHourImp;
import com.examen.nach.entity.Employee;
import com.examen.nach.entity.EmployeeWorkedHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee-worked-hour")
public class EmployeeResWorkedHour {
    @Autowired
    private final IEmployeesImp employeesImp;
    @Autowired
    private final IEmployeeWorkedHourImp employeeWorkedHourImp;

    public EmployeeResWorkedHour(IEmployeesImp employeesImp, IEmployeeWorkedHourImp employeeWorkedHourImp) {
        this.employeesImp = employeesImp;
        this.employeeWorkedHourImp = employeeWorkedHourImp;
    }

    @GetMapping("/get-all")
    List<EmployeeWorkedHour> getAllEmployeeWorkedHours() {
        return employeeWorkedHourImp.getAllEmployeeWorkedHour();
    }

    @PostMapping(value = "/employee-add-hours")
    ResponseEntity<Map<String, String>> saveEmployee(@RequestBody EmployeeWorkedHour employeeWorkedHour){
        Map<String,String> map=new HashMap<>();

        if (!employeeWorkedHourImp.findByWorkedDateAndEmployeeId(employeeWorkedHour.getWorkedDate(), employeeWorkedHour.getEmployeeId()).isEmpty()) {
            map.put("id", "null");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }

        if (!employeesImp.getByIdEmployee(employeeWorkedHour.getEmployeeId()).isEmpty()) {
            map.put("id", "null");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }

        if (employeeWorkedHour.getWorkedHours()>=20) {
            map.put("id", "null");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        if( !employeeWorkedHour.getWorkedDate().equals(LocalDate.now()) || !employeeWorkedHour.getWorkedDate().isBefore(LocalDate.now())){
            map.put("id", "null");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }

        EmployeeWorkedHour empl=employeeWorkedHourImp.createEmployeeWorkedHour(employeeWorkedHour);
        map.put("id", empl.getEmployeeId().toString());
        map.put("success", "true");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
}
