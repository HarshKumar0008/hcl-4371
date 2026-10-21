package pack8;

import java.util.*;

public class priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        pq.offer(5);

        System.out.println("Priority Queue: " + pq);

        // View smallest element
        System.out.println("Peek: " + pq.peek());

        // Remove smallest element
        System.out.println("Poll: " + pq.poll());

        System.out.println("After poll: " + pq);

        // Check element
        System.out.println("Contains 20: " + pq.contains(20));

        System.out.println("Size: " + pq.size());


        pq.remove(20);
        System.out.println("After remove: " + pq);


        System.out.println("Elements:");
        for (int x : pq) {
            System.out.println(x);
        }


        System.out.println("Empty: " + pq.isEmpty());


        pq.clear();
        System.out.println("After clear: " + pq);
    }
}
