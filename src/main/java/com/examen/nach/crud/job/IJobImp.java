package com.examen.nach.crud.job;

import com.examen.nach.entity.Job;

import java.util.List;

public interface IJobImp {
    List<Job> getAllJob();
    boolean getByIdJob(long id);
}
