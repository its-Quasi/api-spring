package com.apiJobs.jobApp.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
  List<Job> findAll();
  String createJob(Job job);
}
