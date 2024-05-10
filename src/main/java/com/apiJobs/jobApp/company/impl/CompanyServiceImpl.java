package com.apiJobs.jobApp.company.impl;

import com.apiJobs.jobApp.company.Company;
import com.apiJobs.jobApp.company.CompanyRepository;
import com.apiJobs.jobApp.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;

  @Override
  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public Company getCompany(Long id) {
    return companyRepository.findById(id).orElse(null);
  }

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }
}
