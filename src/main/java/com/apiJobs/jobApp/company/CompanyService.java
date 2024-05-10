package com.apiJobs.jobApp.company;

import java.util.List;

public interface CompanyService {
  List<Company> getAllCompanies();
  Company getCompany(Long id);
}
