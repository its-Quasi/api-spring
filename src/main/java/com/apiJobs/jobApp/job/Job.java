package com.apiJobs.jobApp.job;

import lombok.Data;

import java.util.Objects;

@Data
public class Job {
  public Long id;
  public String title;
  public String description;
  public String minSalary;
  public String maxSalary;
  public String location;

  public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.minSalary = minSalary;
    this.maxSalary = maxSalary;
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Job job = (Job) o;
    return Objects.equals(id, job.id);
  }
}
