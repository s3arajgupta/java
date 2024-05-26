package practice.leetcode75;

import java.util.HashMap;

public class longestSubarrayof1sAfterDeletingOneElement {
    
    public static void main(String[] args) {

        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
        // int[] nums = {0,1,1,1,0,1,1,0,1};
        // System.out.println(longestSubarray(nums));
        // int[] nums = {1,1,1};
        // System.out.println(longestSubarray(nums));
        
    }

    public static int longestSubarray (int[] nums) {

        int max = 0, l = 0, r = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        while (r < nums.length) {

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (r - l + 1 - map.getOrDefault(1, 0) > 1) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
                // System.out.println("mapwhile" + map);
            }

            // System.out.println(map);
            max = Math.max(max, r - l + 1);
            r++;
            
        }

        return max - 1;
        
    }
    
}
