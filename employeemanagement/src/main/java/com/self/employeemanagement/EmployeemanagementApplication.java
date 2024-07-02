package com.self.employeemanagement;

import com.self.employeemanagement.Entity.Employee;
import com.self.employeemanagement.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeemanagementApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);
	}


}
