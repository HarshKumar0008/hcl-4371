package pack9;


interface B {
    void show();
}

public class interfaceImpl3 {
    public static void main(String[] args) {
        B obj = () -> System.out.println("Hello");
        obj.show();
    }
}