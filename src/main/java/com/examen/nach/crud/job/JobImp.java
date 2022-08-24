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
        return jobService.getAllJob();
    }

    @Override
    public Optional<Job> getByIdJob(long id) {
        return jobService.getByIdJob(id);
    }

    @Override
    public Job createJob(Job job) {
        return jobService.createJob(job);
    }
}
