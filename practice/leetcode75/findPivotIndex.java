package practice.leetcode75;

public class findPivotIndex {

    public static void main(String[] args) {

        // int[] nums = {1,7,3,6,5,6};
        // System.out.println(pivotIndex(nums));
        // int[] nums = {1,2,3};
        // System.out.println(pivotIndex(nums));
        int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
        
    }

    public static int pivotIndex (int[] nums) {

        int lhs = 0;int rhs = 0;

        for (int i : nums) rhs += i;

        for (int i = 0; i < nums.length; i++) {

            // System.out.println(lhs  + " " + rhs);
            lhs += nums[i];
            if (rhs == lhs) return i;
            rhs -= nums[i];
            
        }

        return -1;
        
    }
    
}
