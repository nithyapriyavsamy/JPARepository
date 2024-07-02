package com.self.employeemanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Employees")
@Getter
@Setter
//@NamedQuery(
//        name="findByDepartment",
//        query = "select e from Employee e where e.department=?1"
//)
@NamedQueries(
        {
                @NamedQuery(
                        name="Employee.findByDepartment",
                        query = "select e from Employee e where e.name=?1"
                ),
                @NamedQuery(
                        name="Employee.findCustom",
                        query = "select e from Employee e ORDER BY e.name"
                )
})
@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Employee.findAgeAndName",
                        query = "Select * from Employees e where e.name=?1 and e.age=?2",
                        resultClass = Employee.class
                )

})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public int age;
    public String department;
}
