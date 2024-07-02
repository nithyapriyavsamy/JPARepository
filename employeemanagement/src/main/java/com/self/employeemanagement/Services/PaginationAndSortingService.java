package com.self.employeemanagement.Services;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.Repositories.EmployeeRepository;
import com.self.employeemanagement.ReqAndResModels.SortingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationAndSortingService {
    @Autowired
    EmployeeRepository repository;

    public Page Pagination(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page page = repository.findAll(pageable);
        return page;
    }

    public List<Employee> Sorting(String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase("DESC")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        List<Employee> employees = repository.findAll(sort);
        return employees;
    }

    public List<Employee> Sorting(SortingModel sort1, SortingModel sort2){
        Sort sorts1 = sort1.sortDir.equalsIgnoreCase("DESC")
                ? Sort.by(sort1.sortBy).descending()
                : Sort.by(sort1.sortBy).ascending();
        Sort sorts2 = sort2.sortDir.equalsIgnoreCase("DESC")
                ? Sort.by(sort2.sortBy).descending()
                : Sort.by(sort2.sortBy).ascending();
        Sort sortGroup = sorts1.and(sorts2);
        List<Employee> employees = repository.findAll(sortGroup);
        return employees;
    }

    public Page SortingAndPagination(int pageNo, int pageSize, SortingModel sort){
        Sort sorts = sort.sortDir.equalsIgnoreCase("DESC")
                ? Sort.by(sort.sortBy).descending()
                : Sort.by(sort.sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sorts);
        Page page = repository.findAll(pageable);
        return page;
    }
}