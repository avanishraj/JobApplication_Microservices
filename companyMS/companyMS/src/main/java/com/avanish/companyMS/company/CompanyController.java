package com.avanish.companyMS.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    public CompanyController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    CompanyServices companyServices;

    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestBody CompanyEntity company){
        companyServices.addCompany(company);
        return ResponseEntity.ok("Company added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        companyServices.deleteCompanyById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @GetMapping()
    public ResponseEntity<List<CompanyEntity>> getAllCompanies(){
        return ResponseEntity.ok(companyServices.getAllCompanies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody CompanyEntity updateCompany){
        boolean updated = companyServices.updateCompanyById(id, updateCompany);
        if (updated){
            return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> getCompaniesById(@PathVariable Long id){
        CompanyEntity company = companyServices.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
