package practice.leetcode75;

import java.util.*;

public class uniqueNumberOfOccurrences {

    public static void main(String[] args) {
        
        // int [] arr = {1,2,2,1,1,3};
        // int [] arr = {1,2};
        int [] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
        
    }

    public static boolean uniqueOccurrences (int[] arr) {

        HashMap <Integer, Integer> map = new HashMap<>();

        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);

        Set <Integer> set = new HashSet<>();
        for ( int i : map.values()) set.add(i);

        if (map.size() == set.size()) return true;
        else return false;
        
    }
    
}
