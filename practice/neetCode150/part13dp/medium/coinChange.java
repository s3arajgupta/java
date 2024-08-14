package practice.neetCode150.part13dp.medium;

import java.util.Arrays;

public class coinChange {

    public static void main(String[] args) {

        coinChange sol = new coinChange();
        // int[] coins = { 1, 2, 5 };
        // System.out.println(sol.coinChangeFunc(coins, 11));
        int[] coins = { 2 };
        System.out.println(sol.coinChangeFunc(coins, 3));

    }

    public int coinChangeFunc(int[] coins, int amount) {

        if (amount < 0 || coins.length == 0 || coins == null)
            return -1;

        int[] dp = new int[amount + 1];
        int n = dp.length;
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int a = 1; a < n; a++) {
            for (int c : coins) {

                if (a - c >= 0)
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]); // Recurrence relation

            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

}
