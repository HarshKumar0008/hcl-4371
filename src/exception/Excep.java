
package exception;

public class Excep {

    static void divide(int a, int b) throws Exception {
        System.out.println(a / b);
    }

    public static void main(String[] args) {
        try {
            divide(10, 0);

            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);
//            return ;

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Exception: " + e);
        } catch (Exception e) {
            System.out.println("General Exception: " + e);
        } finally {
            System.out.println("Finally block executed");
//            return;
        }
    }
}
