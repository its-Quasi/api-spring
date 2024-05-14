package com.apiJobs.jobApp.job;

import com.apiJobs.jobApp.company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.model.internal.BinderHelper;

import java.util.Objects;


@Data
@NoArgsConstructor
@Entity(name = "job")
public class Job {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private String minSalary;
  private String maxSalary;
  private String location;

  @ManyToOne
  @JsonBackReference
  private Company company;

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
