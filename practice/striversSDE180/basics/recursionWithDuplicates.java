package practice.striversSDE180.basics;

import java.util.*;

public class recursionWithDuplicates {

    public static void permutate(int index, int[] nums, List<List<Integer>> ans){

        if (index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            swap(i, index, nums);
            permutate(index+1, nums, ans);
            swap(i, index, nums);       //reswaping for next recursion, 
        }
    }

    public static void swap (int i, int j, int[] nums){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String args[]){
        
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {3,2,1};
    
        permutate(0, nums, ans);
        System.out.println(ans);
    }

}
