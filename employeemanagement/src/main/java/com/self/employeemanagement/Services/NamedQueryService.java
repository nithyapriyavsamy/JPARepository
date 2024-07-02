package com.self.employeemanagement.Services;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamedQueryService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> FindByDepartment(String department){
        return repository.findByDepartment(department);
    }
    public List<Employee> FindByOrdering(){
        return repository.findCustom();
    }
    public List<Employee> FindNameAge(String name, int age){
        return repository.findAgeAndName(name, age);
    }
}
