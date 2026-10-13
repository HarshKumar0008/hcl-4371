package exception;



public class throwException {

    static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {
        try {
            checkAge(16);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");

        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        } finally {
            System.out.println("Finally block executed");
        }
    }
}
