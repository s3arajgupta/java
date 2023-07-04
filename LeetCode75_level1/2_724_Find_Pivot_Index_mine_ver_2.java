package LeetCode75_level1;

class Solution {
    public int pivotIndex(int[] nums) {

        int len = nums.length;
        int LHS = 0;

        for(int i = 1; i <= len; i++){
    
            int RHS = 0;

            LHS = LHS + nums[i-1];

            for(int k = i; k <= len; k++)
                RHS = RHS + nums[k-1];

            if(LHS == RHS)
                return i-1;
        }

    return -1;

    }

}