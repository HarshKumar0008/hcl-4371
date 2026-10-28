package com.example.hrms.model;

import com.example.hrms.repository.EmpRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    private EmpRepositoryImpl impl;

    public int add(){
        return impl.add(10,20);
    }
    public double squareRoot(double d){
        return impl.squareRoot(d);
    }
    public int greater(int a, int b){
        return impl.greater(a,b);
    }
}
