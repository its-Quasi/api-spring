package com.apiJobs.jobApp.job.impl;

import com.apiJobs.jobApp.job.Job;
import com.apiJobs.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceNonDB implements JobService {
  private List<Job> jobs = new ArrayList<>();
  private Long idCounter = 1L;
  @Override
  public List<Job> findAll() {
    return jobs;
  }

  @Override
  public void createJob(Job job) {
    int id = jobs.indexOf(job);
    job.setId(idCounter++);
    jobs.add(job);
  }

  @Override
  public Job getJobById(Long id) {
    for(Job job : jobs) {
      if(Objects.equals(job.getId(), id)) return job;
    }
    return null;
  }

  @Override
  public Boolean deleteById(Long id) {
    for(Job job : jobs) {
      if(Objects.equals(job.getId(), id)) {
        jobs.remove(job);
        return true;
      }
    }
    return false;
  }

  @Override
  public Boolean updateJobById(Long id, Job updatedJob) {
    for (int i = 0; i < jobs.size(); i++) {
      Job job = jobs.get(i);
      if (Objects.equals(job.getId(), id)) {
        updatedJob.setId(id);
        jobs.set(i, updatedJob);
        return true;
      }
    }
    return false;
  }
}
