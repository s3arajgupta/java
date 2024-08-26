package practice.neetCode150.part8HeapPriorityQueue.medium;

import java.util.*;
import modules.*;

public class taskScheduler {

    public static void main(String[] args) {

        // char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        // System.out.println(leastInterval(tasks, 2));
        // char[] tasks = { 'A', 'C', 'A', 'B', 'D', 'B' };
        // System.out.println(leastInterval(tasks, 1));
        char[] tasks = { 'A', 'A', 'B', 'B', 'B' };
        System.out.println(leastInterval(tasks, 2));

    }

    public static int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : map.values())
            maxHeap.add(i);

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        Integer time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            time++;

            if (!maxHeap.isEmpty()) {

                int taskid = maxHeap.poll();

                if (taskid - 1 > 0) {
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(taskid - 1, time + n);
                    queue.add(pair);
                }

            }

            if (!queue.isEmpty()) {

                if (queue.peek().getSecond() <= time) {

                    int smallerTask = queue.poll().getFirst();
                    maxHeap.add(smallerTask);

                }

            }

        }

        return time;

    }

}
