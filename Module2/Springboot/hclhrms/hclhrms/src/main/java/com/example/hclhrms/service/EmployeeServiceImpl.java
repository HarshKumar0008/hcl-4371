package com.example.hclhrms.service;

import com.example.hclhrms.entity.Employee;
import com.example.hclhrms.repository.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeImpl impl;
    public String addEmp(){
        Employee emp1=new Employee(1,"Akash","FSD","java","ak@gmail.com");
       return  impl.addEmp(emp1);
    }
    public ArrayList<Employee> getEmp(){
        return impl.getEmp();
    }
    public Employee getEmployeeById(long id){
        return impl.getEmpById(id);
    }
    public String deleteById(){
        long id =1;
        return impl.deleteById(1);
    }
    public ArrayList<Employee> addInBulk(){
        ArrayList<Employee>emp=new ArrayList<>();
        emp.add(new Employee(2,"rkas","Frontend","React","d"));
        emp.add(new Employee(3,"Voikas","Backend","React","d"));
        emp.add(new Employee(4,"gikas","Aspx","HTMl","d"));
        emp.add(new Employee(5,"dkas","Ai","Python","d"));
       return impl.addInBulk(emp);
    }
   public String updateById(){
        Employee emp=new Employee(5,"ShahRukh","Actor","HTMl","shahrukh@gmail.com");
        return impl.updateById(2,emp);
   }
}
