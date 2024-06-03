package com.apiJobs.jobApp.review.impl;

import com.apiJobs.jobApp.job.Job;
import com.apiJobs.jobApp.review.IReviewService;
import com.apiJobs.jobApp.review.Review;
import com.apiJobs.jobApp.review.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService implements IReviewService {

  private final ReviewRepository reviewRepository;

  @Override
  public List<Review> getReviews(Long companyId) {
    return reviewRepository.findByCompanyId(companyId);
  }

  @Override
  public Review getReviewById(Long companyId, Long reviewId) {
    List<Review> reviews = reviewRepository.findByCompanyId(companyId);
    return reviews
      .stream()
      .filter(review -> review.getId().equals(reviewId))
      .findFirst()
      .orElse(null);
  }

  @Override
  public void createReview(Review review) {
    try {
      reviewRepository.save(review);
    } catch (Exception e) {
      throw new EntityNotFoundException("Don't found company with ID: " + review.getCompany().getId());
    }
  }

  @Override
  public Boolean updateReview(Long id, Review updatedReview) {
    Optional<Review> optReview = reviewRepository.findById(id);
    if(optReview.isPresent()) {
      Review review = optReview.get();
      updatedReview.setId(id);
      updatedReview.setCompany(review.getCompany());
      reviewRepository.save(updatedReview);
      return true;
    }
    return false;
  }

  @Override
  public Boolean deleteReviewById(Long id) {
    try{
      reviewRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
