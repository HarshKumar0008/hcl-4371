

package pack8;

import java.util.*;

public class  treeHashMap {
    public static void main(String[] args) {
        Map<Integer, String> m = new TreeMap<>();

        m.put(3, "Aman");
        m.put(1, "Harsh");
        m.put(2, "Rahul");

        System.out.println(m);
        System.out.println(m.get(2));

        m.put(2, "Rohit");

        System.out.println(m.containsKey(1));
        System.out.println(m.containsValue("Aman"));

        m.remove(3);

        System.out.println(m.size());
        System.out.println(m.isEmpty());

        for (int key : m.keySet()) {
            System.out.println(key + " " + m.get(key));
        }

        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println(m.entrySet());

        m.putIfAbsent(4, "Karan");
        m.replace(1, "Harsh Kumar");

        System.out.println(m);

        m.clear();

        System.out.println(m);
    }
}

