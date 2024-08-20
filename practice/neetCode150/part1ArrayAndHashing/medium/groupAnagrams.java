package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.*;

public class groupAnagrams {

    public static void main(String args[]) {

        List<String> arr = new ArrayList<>();
        arr.add("eat");
        arr.add("tea");
        arr.add("tan");
        arr.add("ate");
        arr.add("nat");
        arr.add("bat");
        System.out.println(groupAnagramsFunc1(arr).toString());

        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagramsFunc2(strs));

    }

    public static List<List<String>> groupAnagramsFunc1(List<String> strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.size(); i++) {
            int[] temp = new int[26];
            for (char j : strs.get(i).toCharArray()) {
                temp[j - 'a']++;
            }
            String array = Arrays.toString(temp);
            if (map.containsKey(array)) {
                List<String> oldList = map.get(array);
                oldList.add(strs.get(i));
                map.replace(array, oldList);
                // System.out.println("if");
            } else {
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

    public static List<List<String>> groupAnagramsFunc2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

}