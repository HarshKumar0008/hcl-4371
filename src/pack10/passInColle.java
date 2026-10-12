package pack10;

import java.util.*;

public class passInColle  {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(50, 10, 40, 20, 30)
        );
        Collections.sort(list, (a, b) -> a - b);
        System.out.println("Ascending: " + list);

        Collections.sort(list, (a, b) -> b - a);
        System.out.println("Descending: " + list);
    }
}