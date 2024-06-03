package com.apiJobs.jobApp.review;

import com.apiJobs.jobApp.company.Company;
import com.apiJobs.jobApp.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
  private final IReviewService reviewService;

  @GetMapping
  public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
    return new ResponseEntity<>(reviewService.getReviews(companyId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> addReview(@RequestBody Review review) {
    try{
      reviewService.createReview(review);
      return new ResponseEntity<>("Review Created successfully" , HttpStatus.CREATED);
    } catch (Exception e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{reviewId}")
  public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
    Review review = reviewService.getReviewById(companyId, reviewId);
    if(review != null) return new ResponseEntity<>(review, HttpStatus.OK);
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{reviewId}")
  public ResponseEntity<String> updateCompanyById(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
    boolean canUpdate = this.reviewService.updateReview(reviewId, updatedReview);
    if(canUpdate) return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{reviewId}")
  public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
     boolean canDelete = reviewService.deleteReviewById(reviewId);
     if(canDelete) {
       return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
