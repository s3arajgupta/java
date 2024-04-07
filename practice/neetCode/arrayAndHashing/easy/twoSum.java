package practice.neetCode.arrayAndHashing.easy;

public class twoSum {
    
    public static void main (String args[]){

        // int[] nums = new int[]{3,2,4}; 
        int[] nums = new int[]{2,15,11,7}; 
        int[] res = new int[2];

        res = twoSumFunc(nums, 9);
        System.err.println(res[0] + " " + res[1]);
        // System.out.println(twoSumFunc({3,2,4}, 6));
        
    }

    static public int[] twoSumFunc(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++){
            int diff = target-nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (diff == nums[j]) return new int[] {i, j};
            }
        }

        return new int[] {0, 0};

    }   

}
