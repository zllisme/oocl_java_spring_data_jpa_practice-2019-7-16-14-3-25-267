package com.tw.apistackbase.Controller;


import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.core.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.emitter.Emitter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    public CompanyRepository companyRepository;

    @GetMapping
    public Iterable<Company> getCompanys() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

    @GetMapping(params = {"name"})
    public Company getCompanyByName(@RequestParam String name) {
        Company company = companyRepository.findByName(name);
        List<Employee> employees = company.getEmployees();
        List<Employee> sortedEmployees = employees.stream().sorted((e1, e2) -> e2.getAge()-e1.getAge()).collect(Collectors.toList());
        company.setEmployees(sortedEmployees);
        return company;
    }




}
