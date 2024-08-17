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

        boolean[] dp = new boolean[n + 1]; // 9 false

        dp[n] = true; // base case // bottom up

        for (int i = n - 1; i >= 0; i--) {
            for (String st : wordDict) {
                if (i + st.length() <= s.length() && s.startsWith(st, i)) {
                // if (i + st.length() <= s.length() && s.substring(i, i +
                //         st.length()).equals(st)) {
                    dp[i] = dp[i + st.length()];
                    // System.out.println(i);
                    // System.out.println(Arrays.toString(dp));
                }
                if (dp[i])
                    break;
            }
        }

        return dp[0];

    }

}
