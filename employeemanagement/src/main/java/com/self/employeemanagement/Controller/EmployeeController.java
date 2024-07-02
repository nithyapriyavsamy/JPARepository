package com.self.employeemanagement.Controller;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.Exceptions.EmployeeNotFoundException;
import com.self.employeemanagement.Repositories.EmployeeRepository;
import com.self.employeemanagement.ReqAndResModels.EmployeeNameAge;
import com.self.employeemanagement.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/a1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> GetAllEmployees(){
        return service.GetAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> GetEmployeeById(@PathVariable int id){
        Employee employee = service.GetEmployeeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public Employee CreateEmployee(@RequestBody Employee employee){
        return service.AddEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable int id, @RequestBody Employee employee){
        Employee updatedEmployee = service.UpdateEmployee(id,employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> DeleteEmployee(@PathVariable int id){
        service.DeleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/All")
    public List<Employee> SaveAll(@RequestBody List<Employee> employees){
        return service.AddMultipleEmployee(employees);
    }

    @PostMapping("/nameAndAge")
    public List<Employee> GetEmployeesByNameAndAge(@RequestBody EmployeeNameAge model){
        return service.FindByNameAndAge(model.name, model.age);
    }

    @GetMapping("distinctAge/{age}")
    public ResponseEntity<List<Employee>> GetEmployeeByAge(@PathVariable int age){
        List<Employee> employeeList = service.FindDistinctByAge(age);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("age>/{age}")
    public ResponseEntity<List<Employee>> GetEmployeeAgeGreater(@PathVariable int age){
        List<Employee> employeeList = service.FindByAgeGreaterThan(age);
        return ResponseEntity.ok(employeeList);
    }
}
