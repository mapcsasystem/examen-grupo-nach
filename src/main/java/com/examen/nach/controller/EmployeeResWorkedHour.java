package com.examen.nach.controller;

import com.examen.nach.crud.employee.IEmployeesImp;
import com.examen.nach.crud.employee_worked_hours.IEmployeeWorkedHourImp;
import com.examen.nach.entity.EmployeeWorkedHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/employee-worked-hour")
public class EmployeeResWorkedHour {
    @Autowired
    private IEmployeesImp employeesImp;
    @Autowired
    private IEmployeeWorkedHourImp employeeWorkedHourImp;

    @GetMapping("/get-all")
    List<EmployeeWorkedHour> getAllEmployeeWorkedHours() {
        return employeeWorkedHourImp.getAllEmployeeWorkedHour();
    }

    @GetMapping(value = "/get-total")
    @ResponseBody
    ResponseEntity<Map<String, Object>> findByWorkedDateBetween(@RequestParam("employee_id") long id, @RequestParam("start_date") LocalDate startDate, @RequestParam("end_date") LocalDate endDate) {
        Map<String, Object> map = new HashMap<>();
       /* if (employeesImp.getByIdEmployee(id).isEmpty()) {
            map.put("total_worked_hours", null);
            map.put("success", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }*/
       /* LocalDate date1 = LocalDate.parse(startDate.toString());
        LocalDate date2 = LocalDate.parse(endDate.toString());
       if(date1.isBefore(date2)){
            map.put("total_worked_hours", null);
            map.put("success", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        List<EmployeeWorkedHour> list = employeeWorkedHourImp.findByWorkedDateBetween(startDate, endDate);
        if (list.isEmpty()) {
            map.put("total_worked_hours", 0);
            map.put("success", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        AtomicInteger count = new AtomicInteger();
        list.stream().forEach(hours -> {
            count.set(count.get() + hours.getWorkedHours());
        });*/
        map.put("total_worked_hours", 0);
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "/add-hours")
    ResponseEntity<Map<String, Object>> saveEmployee(@RequestBody EmployeeWorkedHour employeeWorkedHour) {
        Map<String, Object> map = new HashMap<>();

        if (employeesImp.getByIdEmployee(employeeWorkedHour.getEmployeeId()).isEmpty()) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        if (!employeeWorkedHour.getWorkedDate().equals(LocalDate.now())) {
            if (!employeeWorkedHour.getWorkedDate().isBefore(LocalDate.now())) {
                map.put("id", null);
                map.put("success", false);
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            }
        }
        if (!employeeWorkedHourImp.findByWorkedDateAndEmployeeId(employeeWorkedHour.getWorkedDate(), employeeWorkedHour.getEmployeeId()).isEmpty()) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        if (employeeWorkedHour.getWorkedHours() >= 20) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        EmployeeWorkedHour empl = employeeWorkedHourImp.createEmployeeWorkedHour(employeeWorkedHour);
        map.put("id", empl.getEmployeeId().toString());
        map.put("success", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
