package LeetCode75_level1;

class Solution {
    public int[] runningSum(int[] nums) {

        int[] result = new int[nums.length];

        result[0] = nums[0];

        for (int i = 1; i<nums.length; i++){
            
            result[i] = result[i-1] + nums[i];

        }

        return result;

    }
}

// Complexity Analysis

// Time complexity: O(n)O(n)O(n) where nnn is the length of the input array. This is because we use a single loop that iterates over the entire array to calculate the running sum.

// Space complexity: O(1)O(1)O(1) since we don't use any additional space to find the running sum. Note that we do not take into consideration the space occupied by the output array.