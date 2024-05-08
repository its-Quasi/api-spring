package com.apiJobs.jobApp.job.impl;

import com.apiJobs.jobApp.job.Job;
import com.apiJobs.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceNonDB implements JobService {
  private List<Job> jobs = new ArrayList<>();

  @Override
  public List<Job> findAll() {
    return jobs;
  }

  @Override
  public String createJob(Job job) {
    int id = jobs.indexOf(job);
    if(id == -1) {
      jobs.add(job);
      return "Job created successfully";
    }
    return "Job already exists";
  }
}
