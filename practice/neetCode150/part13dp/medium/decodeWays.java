package practice.neetCode150.part13dp.medium;

// import java.util.Arrays;

public class decodeWays {

    public static void main(String[] args) {

        decodeWays sol = new decodeWays();
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("11106"));
        System.out.println(sol.numDecodings("11116"));
        System.out.println(sol.numDecodings("10"));

    }

    public int numDecodings(String s) {

        int twoBack = 1; // empty string
        int oneBack = (s.charAt(0) == '0') ? 0 : 1;
        int current = oneBack;

        for (int i = 2; i < s.length() + 1; i++) {

            current = 0;
            if (s.charAt(i - 1) != '0')
                current += oneBack;
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
                current += twoBack;

            twoBack = oneBack;
            oneBack = current;

        }

        return oneBack;

    }

    // bottom up
    // sc = O(n)
    // public int numDecodings(String s) {

    // int[] dp = new int[s.length() + 1];
    // dp[0] = 1; // emptyString ?
    // dp[1] = (s.charAt(0) == '0') ? 0 : 1;

    // for (int i = 2; i < s.length() + 1; i++) {

    // if (s.charAt(i - 1) != '0') {
    // dp[i] += dp[i - 1];
    // }
    // if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <
    // '7')) {
    // dp[i] += dp[i - 2];
    // }
    // // System.out.println(Arrays.toString(dp));

    // }

    // return dp[s.length()];

    // }

    // top down with memoization
    // sc = O(n)
    // public int numDecodings(String s) {

    // // System.out.println(Arrays.toString(new Integer[10]));
    // return numDecodings(s, 0, new Integer[s.length()]);

    // }

    // public int numDecodings(String s, int i, Integer[] dp) {

    // if (i == s.length())
    // return 1;
    // if (s.charAt(i) == '0')
    // return 0;
    // if (dp[i] != null)
    // return dp[i];

    // int res = 0;
    // res += numDecodings(s, i + 1, dp);

    // if (i + 1 < s.length() &&
    // (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
    // res += numDecodings(s, i + 2, dp);
    // }

    // dp[i] = res;
    // return dp[i];

    // }

}
