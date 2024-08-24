package practice.neetCode150.part3SlidingWindow.medium;

import java.util.*;

public class longestRepeatingCharacterReplacement {

    public static void main(String args[]) {

        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));

    }

    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0, maxf = 0;

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            maxf = Math.max(maxf, map.get(s.charAt(i)));
            // maxf = Collections.max(map.values());

            while ((right - left + 1) - maxf > k) {

                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;

            }

            right++;

            max = Math.max(max, right - left);

        }

        return max;

    }

}
