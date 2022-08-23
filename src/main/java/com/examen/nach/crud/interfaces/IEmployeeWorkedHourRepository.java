package com.examen.nach.crud.interfaces;
import com.examen.nach.entity.EmployeeWorkedHourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeWorkedHourRepository extends JpaRepository<EmployeeWorkedHourEntity,Long> {

}
