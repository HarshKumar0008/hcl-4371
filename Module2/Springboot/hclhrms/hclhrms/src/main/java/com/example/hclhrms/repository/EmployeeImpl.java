package com.example.hclhrms.repository;
import com.example.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeImpl implements EmployeeRepo{
   ArrayList<Employee>empList=new ArrayList<>();

    @Override
    public String addEmp(Employee emp) {
        empList.add(emp);
        return "Hey "+emp.getEmp_name()+" Employee Added Successfully!" +" with "+emp.toString();
    }

    @Override
    public ArrayList<Employee> getEmp() {
        return new ArrayList<>(empList);
    }

    @Override
    public Employee getEmpById(long empid) {
//        for(int i=0;i<empList.size();i++){
//            if(empList.get(i).getEmp_id()==empid){
//                return empList.get(i);
//            }
//        }
       return empList.stream().filter(e->e.getEmp_id()==empid).findFirst().orElse(null);
    }

    @Override
    public String deleteById(long id) {
//        String msg="";
//        for(int i=0;i<empList.size();i++){
//            if(empList.get(i).getEmp_id()==id){
//                 msg+=empList.get(i).toString();
//               empList.remove(i);
//            }
//        }
//        return "This Employee is deleted : "+ msg;
        boolean status=false;
        if(getEmpById(id)!=null){
            status=empList.removeIf(e->e.getEmp_id()==id);
        }
        else
            return "User DoesNot Exist";
        return "User deleted with Id "+id;
    }

    @Override
    public String updateById(long empid, Employee updatedEmp) {
         Employee existingEmp=getEmpById(empid);
         if(existingEmp!=null){
             existingEmp.setEmp_name(updatedEmp.getEmp_name());
             existingEmp.setEmail(updatedEmp.getEmail());
             existingEmp.setDesignation("HeHe");
         }
        return "Employee updated with : "+updatedEmp.getEmp_name()+" "+ updatedEmp.getEmail()+" "+ updatedEmp.getDesignation();
    }

    @Override
    public ArrayList<Employee> addInBulk(ArrayList<Employee>ls) {
       if(empList.addAll(ls))
           return new ArrayList<>(empList);
       return empList;
    }



}
