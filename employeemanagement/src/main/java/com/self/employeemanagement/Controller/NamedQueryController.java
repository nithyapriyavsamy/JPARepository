package com.self.employeemanagement.Controller;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.ReqAndResModels.EmployeeNameAge;
import com.self.employeemanagement.Services.NamedQueryService;
import com.self.employeemanagement.Services.NativeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/a3/employees")
public class NamedQueryController {
    @Autowired
    private NamedQueryService service;

    @GetMapping("/{department}")
    public ResponseEntity<List<Employee>> FindByDepartment(@PathVariable String department){
        List<Employee> employees = service.FindByDepartment(department);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Employee>> FindByOrdering(){
        List<Employee> employees = service.FindByOrdering();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/NameAge")
    public ResponseEntity<List<Employee>> FindByOrdering(@RequestBody EmployeeNameAge employee){
        List<Employee> employees = service.FindNameAge(employee.name, employee.age);
        return ResponseEntity.ok(employees);
    }
}
