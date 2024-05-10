package com.apiJobs.jobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {

  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping()
  public ResponseEntity<List<Job>> findAll(){
    return ResponseEntity.ok(this.jobService.findAll());
  }

  @PostMapping()
  public ResponseEntity<String> createJob(@RequestBody Job job) {
    this.jobService.createJob(job);
    return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    Job job = this.jobService.getJobById(id);
    if(job != null) {
      return new ResponseEntity<Job>(job, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
    boolean canDelete = this.jobService.deleteById(id);
    if(canDelete) {
      return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
    boolean canUpdate = this.jobService.updateJobById(id, updatedJob);
    if(canUpdate) return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
