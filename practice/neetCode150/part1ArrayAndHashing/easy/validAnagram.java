package practice.neetCode150.part1ArrayAndHashing.easy;

import java.util.*;

public class validAnagram {

    public static void main(String args[]) {

        System.out.println(isAnagramFunc("anagram", "naagram"));
        System.out.println(isAnagramFunc("aaaaaabbbbbb", "aabb"));
        System.out.println(isAnagramFunc("ab", "a"));

    }

    public static boolean isAnagramFunc(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        for (char ch : s1)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (char ch : s2) {
            if (map.containsKey(ch) && map.get(ch) >= 1)
                map.put(ch, map.get(ch) - 1);
            else
                return false;
        }

        for (Integer i : map.values()) {
            if (!i.equals(0))
                return false;
        }

        return true;

    }

    // optimal
    // public static boolean isAnagramFunc(String s, String t) {

    //     int[] arr = new int[26];

    //     for (char i : s.toCharArray())
    //         arr[i - 'a']++;
    //     for (char i : t.toCharArray())
    //         arr[i - 'a']--;

    //     for (int i : arr)
    //         if (i != 0)
    //             return false;

    //     return true;

    // }

}
