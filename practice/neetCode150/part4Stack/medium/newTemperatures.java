package practice.neetCode150.part4Stack.medium;

import java.util.*;

public class newTemperatures {

    public static void main (String args[]){

        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] answers = dailyTemperatures(temperatures);
        for (int i : answers)
            System.out.print(i + " ");
        
    }
    
    public static int[] dailyTemperatures (int[] temperatures){

        int[] answersIndex = new int[temperatures.length];
        Stack<Integer> stackIndex = new Stack<>();

        for (int i = 0 ; i < temperatures.length; i++){
            
            while (!stackIndex.isEmpty() && temperatures[i] > temperatures[stackIndex.peek()]) {
                int prevDay = stackIndex.pop();
                answersIndex[prevDay] = i - prevDay;
                // System.out.println("temperatures[prevDay] " + temperatures[prevDay]);
            }
            
            stackIndex.push(i);
            // System.out.println(stackIndex);

        }
        
        // return new int[4];
        return answersIndex;
        
    }
}
