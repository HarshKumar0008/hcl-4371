package pack5;


class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog barks");
    }
}




class Puppy extends Dog {

    void play() {
        System.out.println("Puppy plays");
    }
}




class Cat extends Animal {

    void meow() {
        System.out.println("Cat meows");
    }
}




interface Father {

    void fatherProperty();
}

interface Mother {

    void motherProperty();
}

class Child implements Father, Mother {

    public void fatherProperty() {
        System.out.println("Father property");
    }

    public void motherProperty() {
        System.out.println("Mother property");
    }
}




class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}

interface Electric {

    void charge();
}

interface GPS {

    void navigate();
}

class Car extends Vehicle implements Electric, GPS {

    public void charge() {
        System.out.println("Car is charging");
    }

    public void navigate() {
        System.out.println("GPS navigation started");
    }

    void drive() {
        System.out.println("Car is driving");
    }
}




public class inherit {

    public static void main(String[] args) {


        System.out.println("---- Single Inheritance ----");

        Dog d = new Dog();

        d.eat();
        d.bark();



        System.out.println("\n---- Multilevel Inheritance ----");

        Puppy p = new Puppy();

        p.eat();
        p.bark();
        p.play();



        System.out.println("\n---- Hierarchical Inheritance ----");

        Cat c = new Cat();

        c.eat();
        c.meow();



        System.out.println("\n---- Multiple Inheritance ----");

        Child child = new Child();

        child.fatherProperty();
        child.motherProperty();



        System.out.println("\n---- Hybrid Inheritance ----");

        Car car = new Car();

        car.start();
        car.charge();
        car.navigate();
        car.drive();
    }
}
