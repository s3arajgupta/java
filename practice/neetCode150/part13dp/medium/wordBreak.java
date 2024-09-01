package practice.neetCode150.part13dp.medium;

import java.util.*;

public class wordBreak {

    public static void main(String[] args) {

        wordBreak sol = new wordBreak();

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(sol.wordBreakFunc(s, wordDict));

    }

    public boolean wordBreakFunc(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {

            for (String word : wordDict) {

                if (i + word.length() <= s.length() && s.startsWith(word, i))

                    dp[i] = dp[i + word.length()];

                if (dp[i]) // if true
                    break;

            }

        }

        return dp[0];

    }

}
