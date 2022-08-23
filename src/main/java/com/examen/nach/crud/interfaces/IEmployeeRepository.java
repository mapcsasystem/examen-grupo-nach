package com.examen.nach.crud.interfaces;
import com.examen.nach.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
