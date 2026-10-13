
package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        );


        List<Integer> even = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());


        List<Integer> odd = nums.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());


        long evenCount = even.stream().count();
        long oddCount = odd.stream().count();

        System.out.println("Even numbers: " + even);
        System.out.println("Even count: " + evenCount);

        System.out.println("Odd numbers: " + odd);
        System.out.println("Odd count: " + oddCount);
    }
}
