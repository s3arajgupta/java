package practice.leetcode75;

import java.util.*;

public class determineIfTwoStringsAreClose {

    public static void main(String[] args) {

        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
        
    }

    public static boolean closeStrings(String word1, String word2) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : word1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (char c : word2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);

        // System.out.println(map1.keySet() + " " + map2.keySet());
        // System.out.println(map1.values() + " " + map2.values());
        // System.out.println("map1.keySet().equals(map2.keySet() " + (map1.keySet().equals(map2.keySet()))); // ninja
        // System.out.println("map1.values().equals(map2.values()) " + (map1.values().equals(map2.values()))); // ninja
        
        // if (map1.keySet().equals(map2.keySet())) { // doesnot going to work for recurring values
        
        //     // System.out.println("else");
        //     Set <Integer> seta = new HashSet<>(map1.values());
        //     Set <Integer> setb = new HashSet<>(map2.values());
        
        //     // for (int i : map1.values()) seta.add(i);
        //     // for (int i : map2.values()) setb.add(i);
        //     System.out.println("seta " + seta);
        //     System.out.println("setb " + setb);
        
        //     if (seta.equals(setb)) return true;
        //     if (seta.equals(setb)) return true;
            
        // }
        
        if (!(map1.keySet().equals(map2.keySet()))) return false;

        ArrayList<Integer> arr1 = new ArrayList<>(map1.values());
        ArrayList<Integer> arr2 = new ArrayList<>(map2.values());
        Collections.sort(arr1);
        Collections.sort(arr2);
        // System.out.println(arr1 + " " + arr2);
        // if ((map1.keySet().equals(map2.keySet())) && (map1.values().equals(map2.values()))) return true; // ninja
        if (arr1.equals(arr2)) return true;
        
        return false;

    }
    
}
