package pack8;

import java.util.*;

public class stackUsiArrDeq {

    public static void main(String[] args) {
        Deque<Integer> s = new ArrayDeque<>();


        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Stack: " + s);


        System.out.println("Top: " + s.peek());


        System.out.println("Popped: " + s.pop());

        System.out.println("After pop: " + s);


        System.out.println("Empty: " + s.isEmpty());

        System.out.println("Size: " + s.size());
    }
}

