package com.apiJobs.jobApp.review;

import com.apiJobs.jobApp.company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private double rating;

  @ManyToOne
  @JsonBackReference
  private Company company;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Review review)) return false;
    return Objects.equals(id, review.id);
  }
}
