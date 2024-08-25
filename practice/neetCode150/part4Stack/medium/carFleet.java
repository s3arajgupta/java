package practice.neetCode150.part4Stack.medium;

import java.util.*;

public class carFleet {

    public static void main(String args[]) {

        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        System.out.println(carFleetFunc(12, position, speed));
        // int[] position = {3};
        // int[] speed = {3};
        // System.out.println(carFleetFunc(10, position, speed));
        // int[] position = {0,2,4};
        // int[] speed = {4,2,1};
        // System.out.println(carFleetFunc (100, position, speed));
        // int[] position = {6,8};
        // int[] speed = {3,2};
        // System.out.println(carFleetFunc (10, position, speed));
        // int[] position = {0,4,2};
        // int[] speed = {2,1,3};
        // System.out.println(carFleetFunc (10, position, speed));

    }

    public static int carFleetFunc(int target, int[] position, int[] speed) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < position.length; i++)
            map.put(position[i], speed[i]);

        int[] sortedArray = Arrays.copyOf(position, position.length);
        Arrays.sort(sortedArray);

        Stack<Double> stack = new Stack<>();

        for (int i = position.length - 1; i >= 0; i--) {

            double time = (double) (target - sortedArray[i]) / map.get(sortedArray[i]);

            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            } else
                stack.add(time);

        }

        return stack.size();

    }

}
