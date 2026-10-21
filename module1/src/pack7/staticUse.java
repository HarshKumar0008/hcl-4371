package pack7;

class Parent {

    static void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {

    static void show() {
        System.out.println("Child show");
    }
}

public class staticUse {

    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();
        Parent pc = new Child();

        p.show();
        c.show();
        pc.show();
    }
}