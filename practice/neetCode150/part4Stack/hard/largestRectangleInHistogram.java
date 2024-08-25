package practice.neetCode150.part4Stack.hard;

import java.util.*;
import modules.*;

public class largestRectangleInHistogram {

    public static void main(String args[]) {

        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));

    }

    public static int largestRectangleArea(int[] heights) {

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int max = 0;
        int start;

        for (int i = 0; i < heights.length; i++) {

            start = i;

            while (!stack.isEmpty() && stack.peek().getSecond() > heights[i]) {

                Pair<Integer, Integer> pair = stack.pop();
                max = Math.max(max, pair.getSecond() * (i - pair.getFirst()));
                start = pair.getFirst();

            }

            stack.push(new Pair<>(start, heights[i]));

        }

        while (!stack.isEmpty()) {

            Pair<Integer, Integer> pair = stack.pop();
            max = Math.max(max, pair.getSecond() * (heights.length - pair.getFirst()));

        }

        return max;

    }

}
