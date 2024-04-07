package practice.neetCode.arrayAndHashing.easy;

import java.util.HashMap;

public class twoSumOptimal {
    
    public static void main (String args[]){

        // int[] nums = new int[]{3,2,4}; 
        int[] nums = new int[]{2,5,7,11,15}; 
        int[] res = new int[2];

        res = twoSumFunc(nums, 19);
        System.err.println(res[0] + " " + res[1]);
        // System.out.println(twoSumFunc({3,2,4}, 6));
        
    }

    static public int[] twoSumFunc(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                // System.out.println("if");
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        System.out.println(map);
        
        return new int[] {};
    }   
}
