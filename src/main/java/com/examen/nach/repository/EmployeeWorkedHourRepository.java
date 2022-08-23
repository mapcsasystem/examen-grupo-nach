package com.examen.nach.repository;

import com.examen.nach.entity.EmployeeWorkedHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeWorkedHourRepository extends JpaRepository<EmployeeWorkedHour,Long> {
}
