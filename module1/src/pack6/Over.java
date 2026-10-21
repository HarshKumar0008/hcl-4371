package pack6;

class Parent {

    void show() {
        System.out.println("Parent show()");
    }

    void display() {
        System.out.println("Parent display()");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child show()");
    }

    void test() {
        System.out.println("Child test()");
    }

    void showParent() {
        super.show();
    }
}

public class Over {

    public static void main(String[] args) {

        Child c = new Child();
        Parent p = new Child();


        c.show();
        c.showParent();


    }
}