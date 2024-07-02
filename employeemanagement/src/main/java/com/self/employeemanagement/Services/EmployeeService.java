package com.self.employeemanagement.Services;

import com.self.employeemanagement.Exceptions.EmployeeNotFoundException;
import com.self.employeemanagement.Repositories.EmployeeRepository;
import com.self.employeemanagement.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> GetAll(){
        return repository.findAll();
    }

    public Employee GetEmployeeeById(int Id){
        Employee employee = repository.findById(Id)
                .orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        return employee;
    }
    public Employee AddEmployee(Employee employee){
        return repository.save(employee);
    }
    public Employee UpdateEmployee(int id, Employee employee){
        Employee availableEmployee = repository.findById(id)
                .orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        availableEmployee.setName(employee.getName());
        availableEmployee.setDepartment(employee.getDepartment());
        Employee updatedEmployee = repository.save(availableEmployee);
        return updatedEmployee;
    }
    public void DeleteEmployee(int id){
        Employee availableEmployee = repository.findById(id)
                .orElseThrow(()->{throw new EmployeeNotFoundException("There is no employee in this id");});
        repository.delete(availableEmployee);
    }

    public List<Employee> AddMultipleEmployee(List<Employee> employees){
        List<Employee> AddedEmployees = repository.saveAll(employees);
        return AddedEmployees;
    }

    public List<Employee> FindByNameAndAge(String name, int age){
        List<Employee> Employees = repository.findByNameAndAge(name, age);
        return Employees;
    }

    public List<Employee> FindDistinctByAge(int age){
        return repository.findDistinctByAge(age);
    }

    public List<Employee> FindByAgeGreaterThan(int age){
        return repository.findByAgeGreaterThan(age);
    }
}
