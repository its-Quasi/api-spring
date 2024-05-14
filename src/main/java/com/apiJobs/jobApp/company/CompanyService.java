package com.apiJobs.jobApp.company;

import java.util.List;

public interface CompanyService {
  List<Company> getAllCompanies();
  Company getCompany(Long id);
  Boolean updateCompany(Long id, Company company);
  Company createCompany(Company company);
  Boolean deleteCompany(Long id);
}
