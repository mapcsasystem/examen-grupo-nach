package com.examen.nach.crud.interfaces;
import com.examen.nach.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<JobEntity,Long> {

}
