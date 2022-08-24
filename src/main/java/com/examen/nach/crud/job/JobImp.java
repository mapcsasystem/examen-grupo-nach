package com.examen.nach.crud.job;

import com.examen.nach.entity.Job;
import com.examen.nach.service.JobService;

import java.util.List;
import java.util.Optional;

public class JobImp implements IJobImp {
    JobService jobService;

    public JobImp(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public List<Job> getAllJob() {
        return null;
    }

    @Override
    public boolean getByIdJob(long id) {
        return Optional.empty();
    }
}
