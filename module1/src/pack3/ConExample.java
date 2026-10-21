

package pack3;


public class ConExample {

    int a;
    int b;
    String s;


    public ConExample() {

        System.out.println("Default constructor");
    }

    public ConExample(String s) {
        this.s = s;
        System.out.println("String constructor: " + this.s);
    }


    public ConExample(int a, int b) {
        this.a = a;
        this.b = b;

        System.out.println("a = " + this.a);
        System.out.println("b = " + this.b);
    }
}
