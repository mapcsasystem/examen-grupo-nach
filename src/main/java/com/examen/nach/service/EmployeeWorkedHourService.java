package com.examen.nach.service;

import com.examen.nach.entity.Employee;
import com.examen.nach.entity.EmployeeWorkedHour;
import com.examen.nach.repository.EmployeeWorkedHourRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeWorkedHourService {
    private final EmployeeWorkedHourRepository employeeWorkedHourRepository;

    public EmployeeWorkedHourService(EmployeeWorkedHourRepository employeeWorkedHourRepository) {
        this.employeeWorkedHourRepository = employeeWorkedHourRepository;
    }

    public List<EmployeeWorkedHour> getAllEmployeeWorkedHour(){
        return employeeWorkedHourRepository.findAll();
    }

    public Optional<EmployeeWorkedHour> getByIdEmployeeWorkedHour(long id){
        return employeeWorkedHourRepository.findById(id);
    }

    public EmployeeWorkedHour createEmployeeWorkedHour(EmployeeWorkedHour employeeWorkedHour){
        return employeeWorkedHourRepository.save(employeeWorkedHour);
    }

    public List<EmployeeWorkedHour> findByWorkedDateAndEmployeeId(LocalDate workedDate ,Long employeeId){
        return employeeWorkedHourRepository.findByWorkedDateAndEmployeeId(workedDate,employeeId);
    }

}
