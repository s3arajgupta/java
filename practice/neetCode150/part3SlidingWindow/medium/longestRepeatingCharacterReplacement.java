package practice.neetCode150.part3SlidingWindow.medium;

import java.util.*;

public class longestRepeatingCharacterReplacement {

    public static void main(String args[]) {

        // String s = "ABAB";
        // int k = 2;
        // String s = "ABAA";
        // int k = 0;
        String s = "AABABBA";
        int k = 1;
        // String s = "ABBB";
        // int k = 2;
        int res = characterReplacement(s, k);
        System.out.println(res);

    }

    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0, maxf = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            // maxf ?
            maxf = Math.max(maxf, map.get(s.charAt(i)));
            while ((right - left + 1) - maxf > k) {
                // System.out.println(Collections.max(map.values()));
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

}
