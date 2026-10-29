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

    public String getById(Long id) {

        if (id == null) {
            return "Employee ID is required";
        }

        if (employeeRepository.findById(id).isEmpty()) {
            return "Not Found";
        }

        return "User exists with ID: " + id;
    }

    public Employee login(Long emp_id, String email, String password){
        Optional<Employee> optionalEmployee = employeeRepository.findById(emp_id);
        if (optionalEmployee.isEmpty())
            throw new RuntimeException("Invalid credentials");
        Employee emp=optionalEmployee.get();
        String emailid=emp.getEmail();
        String pass=emp.getPassword();
        if(pass.equals(password) && emailid.equals(email))
            return emp;
        throw new RuntimeException("Invalid credentials");
    }

    public String deleteById(Long id){
        if(employeeRepository.findById(id).isEmpty())
            return "User Does Not Exist";
        employeeRepository.deleteById(id);
        return "User Deleted Successfully";
    }

    public String updateEmployee(Long id, Employee emp) {
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
