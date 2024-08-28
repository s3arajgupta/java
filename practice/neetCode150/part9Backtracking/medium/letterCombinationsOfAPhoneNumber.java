package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class letterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {

        letterCombinationsOfAPhoneNumber sol = new letterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations("348"));

    }

    List<String> result;
    StringBuilder temp;
    HashMap<Character, String> map;
    String digits;

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new ArrayList<>();

        result = new ArrayList<>();
        temp = new StringBuilder();
        map = new HashMap<>();
        this.digits = digits;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(0, temp);
        return result;

    }

    public void backtracking(int n, StringBuilder temp) {

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

            temp.setLength(n);
            backtracking(n + 1, temp.append(c));

        }

    }

}
