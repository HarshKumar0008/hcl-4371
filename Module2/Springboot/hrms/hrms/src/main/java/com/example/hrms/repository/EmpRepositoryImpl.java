package com.example.hrms.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EmpRepositoryImpl implements EmpRepository{
    @Override
    public double squareRoot(double d) {
        return Math.sqrt(d);
    }

    @Override
    public String empData() {
        return "Akash Rauniyar";
    }
    @Override
    public int add(int a, int b){
        return a+b;
    }
    public int greater(int a, int b){
        return Math.max(a,b);
    }
}
