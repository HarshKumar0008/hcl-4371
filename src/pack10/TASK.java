//built-in functional interfaces in Java, available in the java.util.function package

package pack10;
import java.util.*;
import java.util.function.*;

public class TASK {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(10, 25, 30, 45, 50, 65)
        );

        Predicate<Integer> p = n -> n % 2 == 0;
        System.out.println("Even numbers:");
        list.stream().filter(p).forEach(n -> System.out.print(n + " "));

        Function<Integer, Integer> f = n -> n * n;
        System.out.println("\nSquares:");
        list.stream().map(f).forEach(n -> System.out.print(n + " "));


        Consumer<Integer> c = n -> System.out.println("Number: " + n);
        c.accept(100);


        Supplier<String> s = () -> "Hello Java";
        System.out.println(s.get());


        Collections.sort(list, (a, b) -> Integer.compare(a, b));
        System.out.println("Sorted: " + list);
    }
}

//
//package pack10;
//
//import java.util.*;
//import java.util.function.*;
//
//public class Task {
//    public static void main(String[] args) {
//
//        ArrayList<Integer> list = new ArrayList<>(
//                Arrays.asList(10, 25, 30, 45, 50)
//        );
//
//
//        Predicate<Integer> p = n -> n % 2 == 0;
//
//        System.out.println("Even numbers:");
//        for (int n : list) {
//            if (p.test(n)) {
//                System.out.println(n);
//            }
//        }
//
//
//        Function<Integer, Integer> f = n -> n * n;
//
//        System.out.println("Squares:");
//        for (int n : list) {
//            System.out.println(f.apply(n));
//        }
//
//
//        Consumer<Integer> c = n -> System.out.println(n);
//
//        System.out.println("Numbers:");
//        for (int n : list) {
//            c.accept(n);
//        }
//
//
//        Supplier<String> s = () -> "Hello Java";
//
//        System.out.println(s.get());
//    }
//}