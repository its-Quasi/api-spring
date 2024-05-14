package com.apiJobs.jobApp.company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
@RequiredArgsConstructor
public class CompanyController {

  private final CompanyService companyService;

  @GetMapping
  public ResponseEntity<List<Company>> findAll() {
    return ResponseEntity.ok(companyService.getAllCompanies());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> getCompany(@PathVariable Long id) {
    Company company = companyService.getCompany(id);
    if(company != null) return new ResponseEntity<>(company, HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<String> createCompany(@RequestBody Company company) {
    companyService.createCompany(company);
    return new ResponseEntity<>("Company Created Successfully", HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company toUpdate) {
    boolean canUpdate = companyService.updateCompany(id, toUpdate);
    if(canUpdate) return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
    try {
      companyService.deleteCompany(id);
      return new ResponseEntity<>("Company deleted Successfully", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
