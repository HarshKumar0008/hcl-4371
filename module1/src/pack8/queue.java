package pack8;

import java.util.*;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();


        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println("Queue: " + q);


        q.poll();

        System.out.println("After deleting: " + q);


        q.offer(40);

        System.out.println("After adding: " + q);


    }
}


