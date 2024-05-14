package com.apiJobs.jobApp.company.impl;

import com.apiJobs.jobApp.company.Company;
import com.apiJobs.jobApp.company.CompanyRepository;
import com.apiJobs.jobApp.company.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  @Override
  public Boolean updateCompany(Long id, Company company) {
   Optional<Company> optCompany = companyRepository.findById(id);
   if(optCompany.isPresent()) {
     Company currentCompany = optCompany.get();
     company.setId(currentCompany.getId());
     companyRepository.save(company);
     return true;
   }
   return false;
  }

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }

  @Override
  public Boolean deleteCompany(Long id) {
    try {
      Optional<Company> opt = companyRepository.findById(id);
      companyRepository.delete(opt.get());
      return true;
    } catch (Exception e) {
      throw new EntityNotFoundException("Don't Found Company with ID " + id);
    }
  }
}
