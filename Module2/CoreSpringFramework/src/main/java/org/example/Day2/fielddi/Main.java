package org.example.Day2.fielddi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    public static void main(String[] args) {
        ApplicationContext cxt= new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp=cxt.getBean(Employee.class);
        String res=emp.displayAddress();
        System.out.println(res);
    }
}
