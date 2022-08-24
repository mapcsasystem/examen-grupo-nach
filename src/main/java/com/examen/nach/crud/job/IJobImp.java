package com.examen.nach.crud.job;

import com.examen.nach.entity.Job;

import java.util.List;
import java.util.Optional;

public interface IJobImp {
    List<Job> getAllJob();
    Optional<Job> getByIdJob(long id);
}
