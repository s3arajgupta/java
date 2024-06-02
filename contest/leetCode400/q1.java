package contest.leetCode400;

import java.util.*;

class Solution {

    public static void main(String[] args) {

        System.out.println(minimumChairs("EEEEEE"));
        System.out.println(minimumChairs("ELELEEL"));
        
    }
    
    public static int minimumChairs(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int r = 0, l = 0;
        int max = 0;

        while (r < arr.length){

            char c = arr[r];
            map.put(c, map.getOrDefault(c, 0) + 1);
            System.out.println( map);
            if (c == 'L') {
                map.put(c, map.get('L') - 1);
                l++;
            }
            
            max = Math.max(max, r-l + 1);
            r++;
            
        }
        
        return max;
    }
}