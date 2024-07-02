package com.self.employeemanagement.Controller;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.ReqAndResModels.SortingModel;
import com.self.employeemanagement.Services.PaginationAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/a4/employees")
public class PaginationAndSortingController {
    @Autowired
    PaginationAndSortingService service;

    @GetMapping("/pagination/no/{pageNo}/size/{pageSize}")
    public ResponseEntity<Page>  GetPagination(@PathVariable int pageNo, @PathVariable int pageSize){
        Page page = service.Pagination(pageNo, pageSize);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/sorting/by/{sortBy}/dir/{sortDir}")
    public ResponseEntity<List<Employee>>  Sorting(@PathVariable String sortBy, @PathVariable String sortDir){
        List<Employee> employees = service.Sorting(sortBy, sortDir);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/sorting")
    public ResponseEntity<List<Employee>>  Sorting(@RequestBody SortingModel[] sort){
        List<Employee> employees = service.Sorting(sort[0], sort[1]);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/sortingAndPaging/no/{pageNo}/size/{pageSize}")
    public ResponseEntity<Page>  SortingAndPagination(@RequestBody SortingModel sort, @PathVariable int pageNo, @PathVariable int pageSize){
        Page page = service.SortingAndPagination(pageNo, pageSize, sort);
        return ResponseEntity.ok(page);
    }
}
