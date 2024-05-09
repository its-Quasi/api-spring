package com.apiJobs.jobApp.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
  List<Job> findAll();
  void createJob(Job job);
  Job getJobByid(Long id);
  Boolean deleteById(Long id);
  Boolean updateJobById(Long id, Job updatedJob);
}
