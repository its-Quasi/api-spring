package com.apiJobs.jobApp.job.impl;

import com.apiJobs.jobApp.job.Job;
import com.apiJobs.jobApp.job.JobRepository;
import com.apiJobs.jobApp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JobServiceDb implements JobService {

  @Autowired
  private JobRepository jobRepository;

  @Override
  public List<Job> findAll() {
    return jobRepository.findAll();
  }

  @Override
  public void createJob(Job job) {
    jobRepository.save(job);
  }

  @Override
  public Job getJobById(Long id) {
    return jobRepository.findById(id).orElse(null);
  }

  @Override
  public Boolean deleteById(Long id) {
    try{
      jobRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public Boolean updateJobById(Long id, Job updatedJob) {
    Optional<Job> jobOptional = jobRepository.findById(id);
    if(jobOptional.isPresent()) {
      Job job = jobOptional.get();
      updatedJob.setId(id);
      updatedJob.setCompany(job.getCompany());
      jobRepository.save(updatedJob);
      return true;
    }
    return false;
  }
}
