package com.apiJobs.jobApp.company;

import com.apiJobs.jobApp.job.Job;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  // Jobs of a company
  @OneToMany private List<Job> jobVacancies;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Company company)) return false;
    return Objects.equals(id, company.id);
  }
}
