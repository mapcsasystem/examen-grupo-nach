package com.examen.nach.controller;
import com.examen.nach.crud.job.IJobImp;
import com.examen.nach.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/job")
public class JobResController {

    @Autowired
    private final IJobImp jobImp;

    public JobResController(IJobImp jobImp) {
        this.jobImp = jobImp;
    }

    @GetMapping("/get-all")
    List<Job> getAllEmployees() {
        return jobImp.getAllJob();
    }

    @PostMapping(value = "/create")
    ResponseEntity<Map<String, String>> saveEmployee(@RequestBody Job job){
        Map<String,String> map=new HashMap<>();
        if (job.getName().isEmpty()) {
            map.put("id", "null 1");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        if (job.getSalary().isNaN()) {
            map.put("id", "null 2");
            map.put("success", "false");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }

        Job auxjob=jobImp.createJob(job);
        map.put("id", auxjob.getJobId().toString());
        map.put("success", "true");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
}
