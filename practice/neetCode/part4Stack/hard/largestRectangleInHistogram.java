package practice.neetCode.part4Stack.hard;
// package practice.neetCode.stack.hard;

// import java.util.*;

// public class largestRectangleInHistogram {

//     public static void main (String args[]){

//         int[] heights = {2,1,5,6,2,3};
//         System.out.println(largestRectangleArea(heights));
        
//     }

//     public static int largestRectangleArea (int[] heights){

//         int max = 0;
//         int start;
//         Stack<Pair<Integer, Integer>> stack = new Stack<>();
//         for (int i = 0; i < heights.length; i++) {

//             start = i;

//             while (!stack.isEmpty() && stack.peek().getValue() > heights[i]){

//                 Pair<Integer, Integer> pair = stack.pop();
//                 // int index = pair.getKey();
//                 // int h = pair.getValue();
//                 max = Math.max(max, pair.getValue() * (i - pair.getKey()));
//                 start = pair.getKey();
                
//             }
//             stack.push(new Pair(start, heights[i]));
            
//         }

//         while (!stack.isEmpty()) {
            
//             Pair<Integer, Integer> pair = stack.pop();
//             // int index = pair.getKey();
//             // int h = pair.getValue();
//             max = Math.max(max, pair.getValue() * (heights.length - pair.getKey()));
            
//         }

//         return max;

//     }
// }
