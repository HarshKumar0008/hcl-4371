package pack1;

import pack2.Faculty;

public class Student extends Faculty {

    public String publicVar = "Student Public";

    public static void main(String[] args) {

        Student student = new Student();

        System.out.println(student.publicVar);

        student.m1();   // ✅ protected access
    }
}