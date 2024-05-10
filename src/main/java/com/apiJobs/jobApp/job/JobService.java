package com.apiJobs.jobApp.job;

import java.util.List;

public interface JobService {
  List<Job> findAll();
  void createJob(Job job);
  Job getJobById(Long id);
  Boolean deleteById(Long id);
  Boolean updateJobById(Long id, Job updatedJob);
}
