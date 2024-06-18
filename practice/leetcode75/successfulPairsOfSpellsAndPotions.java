package practice.leetcode75;

import java.util.Arrays;

public class successfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {

        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        int[] res = successfulPairs(spells, potions, 7);
        for (int i : res)
            System.out.print(i + " ");

    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length;
        int m = potions.length;

        int[] res = new int[n];
        Arrays.sort(potions); // mlogm
        int l = 0, r = m - 1, mid = 0;

        for (int i = 0; i < n; i++) {

            l = 0;
            r = m - 1;

            while (l <= r) {
                mid = l + (r - l) / 2;
                long product = (long) spells[i] * potions[mid]; // ninja
                if (product >= success)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            // System.out.println(mid);
            res[i] = m - l; // ninja

        }

        return res;

    }
}
