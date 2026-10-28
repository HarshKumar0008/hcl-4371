package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public String createNewEmployee(Employee employee){
//        Employee emp1=new Employee(1,"Akash","java","Full stack");
//        Employee emp2=new Employee(2,"Vikas","java","Full stack");
//        Employee emp3=new Employee(3,"manav","java","Full stack");

        employeeRepository.save(employee);
        return " saved Successfully";
    }

    public String getById(long id){
        if(employeeRepository.findById(id).isEmpty())
            return "Not Found";
        return "User exist with: "+ id;
    }

    public String login(long emp_id, String email, String password){
        Optional<Employee> optionalEmployee = employeeRepository.findById(emp_id);
        if (optionalEmployee.isEmpty())
            return "Employee not found with ID: " + emp_id;
        Employee emp=optionalEmployee.get();
        String emailid=emp.getEmail();
        String pass=emp.getPassword();
        if(pass.equals(password) && emailid.equals(email))
            return "Login Successful";
        return "Not Foufnd";
    }

    public String deleteById(long id){
        if(employeeRepository.findById(id).isEmpty())
            return "User Does Not Exist";
        employeeRepository.deleteById(id);
        return "User Deleted Successfully";
    }

    public String updateEmployee(long id, Employee emp) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty())
            return "Employee not found with ID: " + id;
         Employee employee=optionalEmployee.get();
         employee.setEmp_name(emp.getEmp_name());
         employee.setStack(emp.getStack());
         employee.setDesignation(emp.getDesignation());
         employee.setPassword(emp.getPassword());
         employee.setEmail(emp.getEmail());

        employeeRepository.save(emp);

        return "Employee updated successfully";
    }

}
