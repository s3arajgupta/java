package practice.leetcode75;

import java.util.*;

public class RecentCounter {

    public static void main(String[] args) {

        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(2));
        System.out.println(obj.ping(1300));
        System.out.println(obj.ping(13000));

    }

    public static Queue<Integer> Q; // ninja
    // public static Deque<Integer> Q; // ninja

    public RecentCounter() {
        Q = new LinkedList<Integer>();
    }

    public int ping(int t) {

        Q.add(t);
        while (t - Q.peek() > 3000) {
            Q.poll();
        }
        return Q.size();

    }

}
