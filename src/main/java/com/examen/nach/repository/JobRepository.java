package com.examen.nach.repository;
import com.examen.nach.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity,Long> {

}
