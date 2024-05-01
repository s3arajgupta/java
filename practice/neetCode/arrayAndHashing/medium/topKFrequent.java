package practice.neetCode.arrayAndHashing.medium;

import java.util.*;

public class topKFrequent {
    
    public static void main (String args[]){
        
        int k = 3;
        int[] nums = new int[]{1,1,1,2,2,3,5,5};
        // int[] nums = new int[]{6,6,6,6,6,6};
        int [] res = new int[k];
        res = topKFrequentFunc(nums, k);
        
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " @ ");
        
    }
    
    public static int[] topKFrequentFunc(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }        
        // System.out.println(map);
        
        List<Integer> freq[] = new ArrayList[nums.length + 1];
        for (Integer i : map.keySet()){
            int value = map.get(i);
            if (freq[value] == null) freq[value] = new ArrayList<>();
            freq[value].add(i);
        }
        
        // for (List<Integer> i : freq)
                // System.out.println(i);
        
        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--){
            if (freq[i] != null){
                for (int j : freq[i]){
                    res[index] = j;
                    index++;
                    // System.out.print(j + " ");
                    if (index == k) return res;
                }
            }
        }

        // return res;
        return new int[]{};
    }
}