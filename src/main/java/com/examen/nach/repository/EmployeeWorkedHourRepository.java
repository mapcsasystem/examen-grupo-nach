package com.examen.nach.repository;

import com.examen.nach.entity.Employee;
import com.examen.nach.entity.EmployeeWorkedHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeWorkedHourRepository extends JpaRepository<EmployeeWorkedHour,Long> {
    List<EmployeeWorkedHour> findByWorkedDateAndEmployeeId(LocalDate workedDate,Long employeeId );
    List<EmployeeWorkedHour> findByWorkedDateBetween(LocalDate startDate, LocalDate endDate );
}
