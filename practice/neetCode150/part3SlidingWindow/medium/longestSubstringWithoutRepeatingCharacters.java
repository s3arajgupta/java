package practice.neetCode150.part3SlidingWindow.medium;

import java.util.*;

public class longestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("qrsvbspk"));
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));

    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<Character>();

        while (right < s.length()) {

            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, set.size());
            right++;

        }

        return max;

    }

}
