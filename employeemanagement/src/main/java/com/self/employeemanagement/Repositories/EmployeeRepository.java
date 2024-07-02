package com.self.employeemanagement.Repositories;

import com.self.employeemanagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    //Finder Methods
    List<Employee> findByNameAndAge(String name, int age);
    List<Employee> findDistinctByAge(int age);
    List<Employee> findByAgeGreaterThan(int age);

    //JPQL Query
    @Query("select e from Employee e where e.name=?1 or e.age=?2")
    List<Employee> getEmployees(String name, int age);
    @Query("select e from Employee e where e.name = :name or e.age = :age")
    List<Employee> getEmployee(@Param("name") String name, @Param("age") int age);

    //Native query
    @Query(value = "select * from Employees e where e.name=?1 or e.age=?2", nativeQuery = true)
    List<Employee> fetchEmployees(String name, int age);
    @Query(value="select * from Employees e where e.name = :name or e.age = :age", nativeQuery = true)
    List<Employee> fetchEmployee(@Param("name") String name, @Param("age") int age);

    //Named Query
    List<Employee> findByDepartment(String department);
    List<Employee> findCustom();

    //NamedNativeQuery
    List<Employee> findAgeAndName(String name, int age);

}
