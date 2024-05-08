package com.apiJobs.jobApp.job;

import com.apiJobs.jobApp.job.impl.JobServiceNonDB;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping()
  public List<Job> findAll(){
    return jobService.findAll();
  }

  @PostMapping()
  public String createJob(@RequestBody Job job) {
    return this.jobService.createJob(job);
  }
}
