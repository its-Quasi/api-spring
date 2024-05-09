package com.apiJobs.jobApp.job.impl;

import com.apiJobs.jobApp.job.Job;
import com.apiJobs.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceDb implements JobService {
  @Override
  public List<Job> findAll() {
    return List.of();
  }

  @Override
  public void createJob(Job job) {

  }

  @Override
  public Job getJobByid(Long id) {
    return null;
  }

  @Override
  public Job deleteById(Long id) {
    return null;
  }

  @Override
  public Boolean updateJobById(Long id, Job updatedJob) {
    return null;
  }
}
