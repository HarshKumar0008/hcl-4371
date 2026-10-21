
package pack8;

import java.util.ArrayList;
import java.util.Comparator;

class Student {
    private String name;
    private int rollNo;
    private int age;
    private int marks;

    public Student(String name, int rollNo, int age, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " | Roll No: " + rollNo
                + " | Age: " + age
                + " | Marks: " + marks;
    }
}

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Harsh", 1, 21, 85));
        list.add(new Student("Rahul", 2, 19, 92));
        list.add(new Student("Aman", 3, 22, 78));
        list.add(new Student("Rohit", 4, 20, 88));
        list.add(new Student("Priya", 5, 18, 95));
        list.add(new Student("Neha", 6, 21, 81));
        list.add(new Student("Karan", 7, 23, 73));
        list.add(new Student("Anjali", 8, 20, 90));
        list.add(new Student("Vikas", 9, 19, 84));
        list.add(new Student("Sneha", 10, 22, 97));

        System.out.println("Original ArrayList:");
        for (Student s : list) {
            System.out.println(s);
        }

        list.sort(Comparator.comparingInt(Student::getAge));

        System.out.println("\nSorted by Age:");
        for (Student s : list) {
            System.out.println(s);
        }

        list.sort(Comparator.comparingInt(Student::getMarks));

        System.out.println("\nSorted by Marks:");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
