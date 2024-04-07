package practice.neetCode.arrayAndHashing.easy;

import java.util.*;

public class containsDuplicate {
    
    public static boolean containsDuplicateFunc(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++){

            if (set.contains(nums[i]))
                return true;
                
            set.add(nums[i]);
            
        }

        // if (set.size() != nums.length)
        //     return true;
        
        return false;
    }

    public static void main (String args[]){

        int[] ch = {1, 2, 3, 2};
        System.out.println(containsDuplicateFunc(ch));
        
    }

}
