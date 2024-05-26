package practice.leetcode75;

import java.util.*;

public class maxConsecutiveOnesIII {

    public static void main(String[] args) {
        
        // int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        // System.out.println(longestOnes(nums, 2));
        // int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        // System.out.println(longestOnes(nums, 3));
        // int[] nums = {0,0,0,1};
        // System.out.println(longestOnes(nums, 4));
        int[] nums = {0,0,0,0};
        System.out.println(longestOnes(nums, 0));
        
    }

    public static int longestOnes(int[]nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0, max = 0, maxf = 0;

        while (r < nums.length) {

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // System.out.println(l + " " + r + " " + k);
            maxf = Math.max(maxf, map.getOrDefault(1, 0));
            while ((r - l + 1 - maxf) > k){ // Collections.max(map.values())
                // System.out.println("while");
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }

            max = Math.max(max, r - l + 1);
            // System.out.println(max);
            // System.out.println(map);
            r++;
            
        }

        return max;
        
    }
    
}
