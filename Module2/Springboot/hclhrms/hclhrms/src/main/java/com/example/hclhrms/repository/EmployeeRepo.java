package com.example.hclhrms.repository;

import com.example.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface EmployeeRepo {
    public String addEmp(Employee emp);
    ArrayList<Employee> getEmp();
    Employee getEmpById(long empid);
    String deleteById(long empid);
    String updateById(long empid, Employee updatedEmp);
    ArrayList<Employee> addInBulk(ArrayList<Employee> ls);
}
