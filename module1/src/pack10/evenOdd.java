package pack10;

@FunctionalInterface
interface Check {
    void checkEvenOdd(int n);
}

public class evenOdd {
    public static void main(String[] args) {

        Check c = (n) -> {
            if (n % 2 == 0)
                System.out.println(n + " is Even");
            else
                System.out.println(n + " is Odd");
        };

        c.checkEvenOdd(10);
        c.checkEvenOdd(7);
    }
}
