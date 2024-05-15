package com.apiJobs.jobApp.review;

import java.util.List;

public interface IReviewService {
  List<Review> getReviews(Long companyId);
  Review getReviewById(Long companyId, Long reviewId);
  void createReview(Review review);
  Boolean updateReview(Long companyId, Review review);
  Boolean deleteReview(Long id);
}
