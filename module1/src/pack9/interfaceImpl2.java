



package pack9;

interface A {
    void show();
}

public class interfaceImpl2 {
    public static void main(String[] args) {
        A obj = new A() {
            public void show() {
                System.out.println("Hello");
            }
        };

        obj.show();
    }
}
