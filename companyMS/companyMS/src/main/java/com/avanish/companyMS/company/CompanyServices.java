package com.avanish.companyMS.company;

import java.util.List;

public interface CompanyServices {
    void addCompany(CompanyEntity company);

    void deleteCompanyById(Long id);

    List<CompanyEntity> getAllCompanies();

    boolean updateCompanyById(Long id, CompanyEntity updateCompany);

    CompanyEntity getCompanyById(Long id);
}
