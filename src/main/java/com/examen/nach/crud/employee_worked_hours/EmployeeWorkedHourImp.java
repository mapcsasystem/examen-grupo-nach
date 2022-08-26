package com.examen.nach.crud.employee_worked_hours;


import com.examen.nach.entity.EmployeeWorkedHour;
import com.examen.nach.service.EmployeeWorkedHourService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EmployeeWorkedHourImp implements IEmployeeWorkedHourImp {
     EmployeeWorkedHourService employeeWorkedHourService;

    public EmployeeWorkedHourImp(EmployeeWorkedHourService employeeWorkedHourService) {
        this.employeeWorkedHourService = employeeWorkedHourService;
    }

    @Override
    public List<EmployeeWorkedHour> getAllEmployeeWorkedHour() {
        return employeeWorkedHourService.getAllEmployeeWorkedHour();
    }

    @Override
    public Optional<EmployeeWorkedHour> getByIdEmployeeWorkedHour(long id) {
        return employeeWorkedHourService.getByIdEmployeeWorkedHour(id);
    }

    @Override
    public EmployeeWorkedHour createEmployeeWorkedHour(EmployeeWorkedHour employeeWorkedHour) {
        return employeeWorkedHourService.createEmployeeWorkedHour(employeeWorkedHour);
    }

    @Override
    public List<EmployeeWorkedHour> findByWorkedDateAndEmployeeId(LocalDate workedDate, Long employeeId) {
        return employeeWorkedHourService.findByWorkedDateAndEmployeeId(workedDate,employeeId);
    }

    @Override
    public List<EmployeeWorkedHour> findByWorkedDateBetween(LocalDate startDate, LocalDate endDate) {
        return employeeWorkedHourService.findByWorkedDateBetween(startDate,endDate);
    }

}
