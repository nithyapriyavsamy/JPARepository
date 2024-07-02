package com.self.employeemanagement.Services;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.Exceptions.EmployeeNotFoundException;
import com.self.employeemanagement.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NativeQueryService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> GetEmployees(String name, int age){
        List<Employee> Employees = repository.getEmployees(name, age);
                //.orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        return Employees;
    }

    public List<Employee> GetEmployee(String name, int age){
        List<Employee> Employees = repository.getEmployee(name, age);
        //.orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        return Employees;
    }

    public List<Employee> FetchEmployees(String name, int age){
        List<Employee> Employees = repository.fetchEmployees(name, age);
        //.orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        return Employees;
    }

    public List<Employee> FetchEmployee(String name, int age){
        List<Employee> Employees = repository.fetchEmployee(name, age);
        //.orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        return Employees;
    }
}
