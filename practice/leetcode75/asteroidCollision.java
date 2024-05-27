package practice.leetcode75;

import java.util.*;

public class asteroidCollision {
    
    public static void main(String[] args) {

        // int[] asteroid = {5,10,-5};
        // int[] asteroid = {8,-8};
        // int[] asteroid = {10,2,-5};
        // int[] asteroid = {-2,-1,1,2};
        // int[] asteroid = {-2,-2,-1,-2};
        // int[] asteroid = {-2,-2,1,-2};
        int[] asteroid = {1,-2,-2,-2};
        asteroid = asteroidCollisionFunc(asteroid);
        for (Integer i : asteroid) System.out.print(i + " ");

    }
    
    public static int[] asteroidCollisionFunc(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {

                int sum = stack.peek() + asteroids[i]; // ? amazing move // both are moving in different direction

                if (sum < 0) { 
                    stack.pop();
                }
                else if (sum > 0) {
                    asteroids[i] = 0;
                }
                else {
                    stack.pop();
                    asteroids[i] = 0;
                }
                                
            }

            if (asteroids[i] != 0) stack.push(asteroids[i]);

        }
        
        // System.out.println(stack);
        if (stack.size() == 0) return new int[0];
        int[] res = new int[stack.size()];
        for (int i  = stack.size() - 1; i >= 0; i--) res[i] = stack.pop();
        return res;

    }
    
}
