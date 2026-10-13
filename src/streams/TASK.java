
package streams;

import java.util.Arrays;
import java.util.List;

public class TASK {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Rahul", "Rohit", "Aman",
                "Raj", "Priya", "Ravi"
        );


        names.stream()
                .filter(name -> name.startsWith("R"))
                .forEach(System.out::println);


        System.out.println("First:");
        names.stream()
                .filter(name -> name.startsWith("R"))
                .findFirst()
                .ifPresent(System.out::println);


        System.out.println("Any:");
        names.stream()
                .filter(name -> name.startsWith("R"))
                .findAny()
                .ifPresent(System.out::println);


        long count = names.stream()
                .filter(name -> name.startsWith("R"))
                .count();

        System.out.println("Count: " + count);
    }
}
