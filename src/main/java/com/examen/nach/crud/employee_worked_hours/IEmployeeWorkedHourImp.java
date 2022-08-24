package com.examen.nach.crud.employee_worked_hours;

import com.examen.nach.entity.EmployeeWorkedHour;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IEmployeeWorkedHourImp {
    List<EmployeeWorkedHour> getAllEmployeeWorkedHour();
    Optional<EmployeeWorkedHour> getByIdEmployeeWorkedHour(long id);
    EmployeeWorkedHour createEmployeeWorkedHour(EmployeeWorkedHour employeeWorkedHour);
    List<EmployeeWorkedHour> findByWorkedDateAndEmployeeId(LocalDate workedDate, Long employeeId );
}
