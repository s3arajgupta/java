// Do This Propperly Again

package practice.neetCode.slidingWindow.medium;

import java.util.*;

public class longestSubstringWithoutRepeatingCharacters {

    public static void main (String args[]){

        // String s = "abcabcbb";
        // String s = "pwwkew";
        // String s = "aab";
        // String s = "dvdfghvsbcd";
        // String s = "dvdf";
        String s = "aabaab!bb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
        
    }

    public static int lengthOfLongestSubstring (String s){

        int max = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<Character>();

        while (right < s.length()){

            if (set.contains(s.charAt(right))){
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }

            }
            set.add(s.charAt(right));
            System.out.println(s.charAt(right) + " " + right);
            right++;
            max = Math.max(max, set.size());
            System.out.println(set);
        }
        return max;
    }

    // public static int lengthOfLongestSubstring (String s){

    //     int max = 0;
    //     int left = 0, right = 0;
    //     Set<Character> set = new HashSet<Character>();

    //     while (right < s.length()){

    //         if(set.contains(s.charAt(right))){
    //             left ++;
    //             right = left;
    //             set.clear();
    //         }
    //         set.add(s.charAt(right));
    //         right++;
    //         max = Math.max(max, set.size());
    //         // System.out.println(set);
    //     }
    //     return max;
    // }
}
