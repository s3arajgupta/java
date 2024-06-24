package practice.blind75.part1ArrayAndHashing.medium;

import java.util.HashSet;

public class longestConsecutiveSequence {

    public static void main (String args[]){

        // int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {100,4,200,201,202,203,204,205,1,3,2};
        int res = longestConsecutive(nums);
        System.out.println(res);

    }

    public static int longestConsecutive(int[] nums){

        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int max = 0;
        int count = 0;  
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + count)) {
                    count++;
                }
                if (max < count) max = count;
                // count = 0;
                }
            }

        return max;
    }
    
}
