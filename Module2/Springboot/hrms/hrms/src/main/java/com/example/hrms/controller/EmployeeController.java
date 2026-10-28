package com.example.hrms.controller;

import com.example.hrms.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private Employee emp;
//    EmployeeController(Employee emp){
//        this.emp=emp;
//    }
    @GetMapping("/")
    public String welcome(){
        return "<h1 style='color:red'>Welcome to SpringBoot Application <h1/>";
    }

    @GetMapping("/add")
    public int sum(){
        System.out.println("adddddd");
        return emp.add();
    }

    @GetMapping("/root")
    public double squareRoot(){
        return emp.squareRoot(123);
    }
    @GetMapping("/gtn")
    public int greater(){
        return emp.greater(10,20);
    }
}
