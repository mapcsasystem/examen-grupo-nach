package com.examen.nach.service;

import com.examen.nach.entity.Job;
import com.examen.nach.repository.JobRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

   private final JobRepository jobRepository;
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public boolean jobExists(Long id) {
        return jobRepository.existsById(id);
    }
    public List<Job> getAllJob(){
        return jobRepository.findAll();
    }
    public Optional<Job> getByIdJob(long id){
        return jobRepository.findById(id);
    }
    public Job createJob(Job job){
        return jobRepository.save(job);
    }
}
