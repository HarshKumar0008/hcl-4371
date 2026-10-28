package com.example.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository {
    double squareRoot(double d);
    String empData();
    public int add(int a, int b);
}
