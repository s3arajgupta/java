package practice.blind75.part1ArrayAndHashing.easy;

import java.util.*;

public class validAnagram {

    public static boolean isAnagramFunc(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] s1 = s.toCharArray(); 
        char[] s2 = t.toCharArray(); 

        for (char ch : s1){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2){
            if (map.containsKey(ch) && map.get(ch) >= 1){
                map.put(ch, map.get(ch) - 1);
                }
            else
                return false;
        }

        for (Integer i : map.values()){
            if (!i.equals(0)) return false;
        }                
        
        return true;

    }

    public static void main (String args[]){

        System.out.println(isAnagramFunc("anagram", "naagram"));
        System.out.println(isAnagramFunc("aaaaaabbbbbb", "aabb"));
        System.out.println(isAnagramFunc("ab", "a"));
        
    }

    
}
