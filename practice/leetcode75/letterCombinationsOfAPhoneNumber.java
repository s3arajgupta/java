package practice.leetcode75;

import java.util.*;

public class letterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {

        System.out.println("result " + letterCombinations(""));

    }

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new ArrayList<>();

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        System.out.println(map);

        result = new ArrayList<>();
        backtracking(0, new StringBuilder(), digits);
        // System.out.println(result.size());
        return result;
    }

    public static HashMap<Character, String> map;
    public static List<String> result;

    public static void backtracking(int n, StringBuilder temp, String digits) {

        if (n == digits.length() - 1) {

            char[] arr = map.get(digits.charAt(n)).toCharArray();
            for (char c : arr) {
                temp.setLength(n);
                result.add(temp.append(c).toString());
            }
            return;
        }

        char[] arr = map.get(digits.charAt(n)).toCharArray();
        for (char c : arr) {
            backtracking(n + 1, temp.append(c), digits);
            temp.setLength(n);
        }

    }

}
