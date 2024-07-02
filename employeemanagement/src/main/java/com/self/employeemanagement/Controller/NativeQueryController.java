package com.self.employeemanagement.Controller;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.ReqAndResModels.EmployeeNameAge;
import com.self.employeemanagement.Services.NativeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/a2/employees")
public class NativeQueryController {
    @Autowired
    private NativeQueryService service;

    @PostMapping("/jpql/indexParam")
    public ResponseEntity<List<Employee>> GetEmployees(@RequestBody EmployeeNameAge employee){
        List<Employee> employees = service.GetEmployees(employee.name, employee.age);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/jpql/namedParam")
    public ResponseEntity<List<Employee>> GetEmployee(@RequestBody EmployeeNameAge employee){
        List<Employee> employees = service.GetEmployee(employee.name, employee.age);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/native/indexParam")
    public ResponseEntity<List<Employee>> FetchEmployees(@RequestBody EmployeeNameAge employee){
        List<Employee> employees = service.FetchEmployees(employee.name, employee.age);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/native/namedParam")
    public ResponseEntity<List<Employee>> FetchEmployee(@RequestBody EmployeeNameAge employee){
        List<Employee> employees = service.FetchEmployee(employee.name, employee.age);
        return ResponseEntity.ok(employees);
    }
}
