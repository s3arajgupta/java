package practice.neetCode150.part13DynamicProgramming1D.medium;

public class decodeWays {

    public static void main(String[] args) {

        decodeWays sol = new decodeWays();

        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("11106"));
        System.out.println(sol.numDecodings("11116"));
        System.out.println(sol.numDecodings("10"));

    }

    public int numDecodings(String s) {

        int twoBack = 1;
        int oneBack = (s.charAt(0) == '0') ? 0 : 1;
        int curr;

        for (int i = 2; i < s.length() + 1; i++) {

            curr = 0;

            if (s.charAt(i - 1) != '0')
                curr += oneBack;

            if (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
                curr += twoBack;

            twoBack = oneBack;
            oneBack = curr;

        }

        return oneBack;

    }

    // top down with memoization
    // sc = O(n)
    // public int numDecodings(String s) {

    //     return numDecodings(s, 0, new Integer[s.length()]);

    // }

    // public int numDecodings(String s, int i, Integer[] dp) {

    //     if (i == s.length())
    //         return 1;

    //     if (s.charAt(i) == '0') // invalid
    //         return 0;

    //     if (dp[i] != null) // already calculated
    //         return dp[i];

    //     int curr = 0;
    //     curr += numDecodings(s, i + 1, dp);

    //     if (i + 1 < s.length() &&
    //             (s.charAt(i) == '1' ||
    //                     s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
    //         curr += numDecodings(s, i + 2, dp);

    //     dp[i] = curr;
    //     return dp[i];

    // }

}
