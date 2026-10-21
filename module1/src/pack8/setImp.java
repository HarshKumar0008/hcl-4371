package pack8;
import java.util.*;

public class setImp {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();


        s.add(10);
        s.add(20);
        s.add(30);
        s.add(20);
        System.out.println("Set: " + s);


        System.out.println(s.contains(20));


        System.out.println(s.size());


        s.remove(10);
        System.out.println("After remove: " + s);


        System.out.println(s.isEmpty());


        for (int x : s) {
            System.out.println(x);
        }


        s.addAll(Arrays.asList(40, 50));
        System.out.println("After addAll: " + s);


        System.out.println(s.containsAll(Arrays.asList(20, 40)));


        s.removeAll(Arrays.asList(20, 40));
        System.out.println("After removeAll: " + s);


        s.retainAll(Arrays.asList(30, 50));
        System.out.println("After retainAll: " + s);


        Object[] arr = s.toArray();
        System.out.println(Arrays.toString(arr));


        s.clear();
        System.out.println("After clear: " + s);
    }
}

