package com.apiJobs.jobApp.company;

import com.apiJobs.jobApp.job.Job;
import com.apiJobs.jobApp.review.Review;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
  @JsonManagedReference
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<Job> jobVacancies;

  // Reviews of a company
  @JsonManagedReference
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<Review> reviews;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Company company)) return false;
    return Objects.equals(id, company.id);
  }

  @Override
  public String toString() {
    return this.name + " - " + this.id;
  }
}
