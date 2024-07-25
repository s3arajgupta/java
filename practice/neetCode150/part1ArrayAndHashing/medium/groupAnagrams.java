package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.*;

public class groupAnagrams {

    public static void main (String args[]){
        
        List<String> arr = new ArrayList<>();
        arr.add("eat");
        arr.add("tea");
        arr.add("tan");
        arr.add("ate");
        arr.add("nat");
        arr.add("bat");
        
        List<List<String>> res = new ArrayList<>();
        res = groupAnagramsFunc(arr);
        System.out.println("res " + res.toString());
        
    }

    public static List<List<String>> groupAnagramsFunc (List<String> strs){

        HashMap<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.size(); i++){
            int[] temp = new int[26];
            for(char j : strs.get(i).toCharArray()){
                temp[j - 'a']++;
            }
            String array = Arrays.toString(temp);
            if(map.containsKey(array)){
                List<String> oldList = map.get(array);
                oldList.add(strs.get(i));
                map.replace(array, oldList);
                // System.out.println("if");
            }
            else{
                List<String> newList = new ArrayList<>();
                newList.add(strs.get(i));
                map.put(array, newList);
                // System.out.println("else");
            }
        }
        // System.out.println("map " + map);
        
        List<List<String>> res = new ArrayList<>();
        for (List<String> s : map.values())
            res.add(s);

        return res;
    }

    // public static List<List<String>> groupAnagramsFunc (String[] strs){

    //     HashMap<String, List<String>> map = new HashMap<>();
        
    //     for (int i = 0; i < strs.length; i++){
    //         int[] temp = new int[26];
    //         for(char j : strs[i].toCharArray()){
    //             temp[j - 'a']++;
    //         }
    //         String array = Arrays.toString(temp);
    //         if(map.containsKey(array)){
    //             // List<String> oldList = map.get(array);
    //             // oldList.add(strs[i]);
    //             // map.replace(array, oldList);
    //             // System.out.println("if");
    //             map.get(array).add(strs[i]);
    //         }
    //         else{
    //             List<String> newList = new ArrayList<>();
    //             newList.add(strs[i]);
    //             map.put(array, newList);
    //             // System.out.println("else");
    //         }
    //     }
    //     // System.out.println("map " + map);
        
    //     List<List<String>> res = new ArrayList<>();
    //     for (List<String> s : map.values())
    //         res.add(s);

    //     return res;
    // }
    
}


// import java.util.AbstractList;

// class Solution {
    
//     private List<List<String>> res;
//     public List<List<String>> groupAnagrams(String[] strs) {       
//         return new AbstractList<List<String>>() {
//             public List<String> get(int index) {
//                 if (res == null) init();
//                 return res.get(index);
//             }
            
//             public int size() {
//                 if (res == null) init();
//                 return res.size();
//             }
            
//             private void init() {
//                 Map<String, List<String>> map = new HashMap<>();
//                 for (String s : strs) {
//                     int[] count = new int[26];
//                     for (char c : s.toCharArray()) {
//                         count[c - 'a']++;
//                     }
//                     StringBuilder sb = new StringBuilder();
//                     for (int i = 0; i < 26; i++) {
//                         if (count[i] != 0) {
//                             sb.append('a' + i);
//                             sb.append(count[i]);
//                         }
//                     }
//                     String key = sb.toString();
//                     map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
//                     res = new ArrayList<>(map.values());
//                 }
//             }
//         };
//     }
// }


// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<String, List<String>> map = new HashMap<>();

//         for (String str : strs) {

//             char[] charArray = str.toCharArray();
//             Arrays.sort(charArray);
//             String sortedStr = new String(charArray);

//             if (!map.containsKey(sortedStr)) {
//                 map.put(sortedStr, new ArrayList<>());
//             }

//             map.get(sortedStr).add(str);
//         }

//         return new ArrayList<>(map.values());
//     }
// }