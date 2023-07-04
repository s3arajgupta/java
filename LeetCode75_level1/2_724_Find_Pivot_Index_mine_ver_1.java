package LeetCode75_level1;

class Solution {
    public int pivotIndex(int[] nums) {

        int len = nums.length;

        for(int i = 0; i < len; i++){
    
            int LHS = 0, RHS = 0;

            for(int j = 0; j < i; j++)
                LHS = LHS + nums[j];

            for(int k = i+1; k < len; k++)
                RHS = RHS + nums[k];

            if(LHS == RHS)
                return i;
        }
        
        return -1;

    }

}