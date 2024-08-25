package practice.neetCode150.part4Stack.medium;

import java.util.*;

public class dailyTemperatures {

    public static void main(String args[]) {

        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.print(Arrays.toString(dailyTemperaturesFunc(temperatures)));

    }

    public static int[] dailyTemperaturesFunc(int[] temperatures) {

        int[] answersIndex = new int[temperatures.length];
        Stack<Integer> stackIndex = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stackIndex.isEmpty() && temperatures[i] > temperatures[stackIndex.peek()]) {
                int prevDay = stackIndex.pop();
                answersIndex[prevDay] = i - prevDay;
                // System.out.println("temperatures[prevDay] " + temperatures[prevDay]);
            }

            stackIndex.push(i);

        }

        return answersIndex;

    }

}
