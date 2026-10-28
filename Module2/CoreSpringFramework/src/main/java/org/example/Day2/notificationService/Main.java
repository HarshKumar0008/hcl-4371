package org.example.Day2.notificationService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cxt= new AnnotationConfigApplicationContext(AppConfig.class);
        Student student=cxt.getBean(Student.class);
        Student student1=cxt.getBean(Student.class);
        System.out.println(student1.hashCode());
        System.out.println(student.hashCode());
        student.notifyStudent();
        cxt.close();
    }
}
