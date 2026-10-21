package pack10;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class lembda {
    public static void main(String[] args) {

        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;
        Calculator div = (a, b) -> a / b;
        Calculator mod = (a, b) -> a % b;

        System.out.println("Addition: " + add.calculate(10, 5));
        System.out.println("Subtraction: " + sub.calculate(10, 5));
        System.out.println("Multiplication: " + mul.calculate(10, 5));
        System.out.println("Division: " + div.calculate(10, 5));
        System.out.println("Modulus: " + mod.calculate(10, 5));
    }
}