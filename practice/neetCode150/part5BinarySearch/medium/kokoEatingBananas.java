package practice.neetCode150.part5BinarySearch.medium;

public class kokoEatingBananas {

    public static void main(String args[]) {

        int[] piles = { 3, 6, 7, 11 };
        System.out.println(minEatingSpeed(piles, 8));

    }

    public static int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int i : piles)
            max = Math.max(max, i);

        int l = 1, k = max / 2, r = max;
        int res = max;

        while (l <= r) {

            k = l + (r - l) / 2;

            int hTemp = 0;

            for (int i = 0; i < piles.length; i++) {

                hTemp = hTemp + (int) Math.ceil((double) piles[i] / k);

                if (hTemp > h)
                    break;

            }

            if (hTemp <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else
                l = k + 1;

        }

        return res;

    }

    // public static int minEatingSpeed(int[] piles, int h) {

    //     // if (piles.length == 0) return 0; // Given in question
    //     // if (piles.length > h) return -1; // Given in question
    //     // if (piles.length == 1) return 1;

    //     int max = Integer.MIN_VALUE;

    //     for (int i : piles)
    //         max = Math.max(max, i);

    //     int[] k = new int[max];

    //     for (int i = 0; i < max; i++)
    //         k[i] = i + 1;

    //     int l = 0, m = 0, r = k.length - 1;
    //     int res = Integer.MAX_VALUE;

    //     while (l <= r) {

    //         m = l + (r - l) / 2;

    //         int hTemp = 0;

    //         for (int i = 0; i < piles.length; i++) {

    //             hTemp = hTemp + (int) Math.ceil((double) piles[i] / k[m]);

    //             if (hTemp > h)
    //                 break;

    //         }

    //         if (hTemp <= h) {
    //             res = Math.min(res, k[m]);
    //             r = m - 1;
    //         } else
    //             l = m + 1;

    //     }

    //     return res;

    // }

}
