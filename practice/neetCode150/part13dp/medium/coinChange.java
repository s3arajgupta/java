package practice.neetCode150.part13dp.medium;

import java.util.Arrays;

public class coinChange {

    public static void main(String[] args) {

        coinChange sol = new coinChange();

        int[] coins = { 1, 2, 5 };
        System.out.println(sol.coinChangeFunc(coins, 11));
        // int[] coins = { 2 };
        // System.out.println(sol.coinChange(coins, 3));

    }

    public int coinChangeFunc(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // max value

        dp[0] = 0; // base case: 0 coins needed to make amount 0

        for (int i = 1; i < dp.length; i++) {

            for (int c : coins) {

                if (i - c >= 0) // non-negative
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]); // Recurrence relation

            }

        }

        return dp[amount] == amount + 1 ? -1 : dp[amount]; // amount + 1 is default

    }

}
