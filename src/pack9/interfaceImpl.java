package pack9;

interface MyInterface {
    void show();
}

public class interfaceImpl implements MyInterface {

    public void show() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        interfaceImpl obj = new interfaceImpl();
        obj.show();
    }
}


