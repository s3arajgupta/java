class Solution {
    public int pivotIndex(int[] nums) {

        int sum  = 0, LHS = 0;
        
        for(int x: nums) sum += x;

        for(int y = 0; y < nums.length; y++){

            if (LHS == sum - nums[y] - LHS) return y;

            LHS = LHS + nums[y];

        }
        return -1;

    }

}


// Complexity Analysis

// Time Complexity: O(N)O(N)O(N), where NNN is the length of nums.

// Space Complexity: O(1)O(1)O(1), the space used by leftsum and S.