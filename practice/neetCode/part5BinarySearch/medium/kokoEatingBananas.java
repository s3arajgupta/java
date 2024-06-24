package practice.neetCode.part5BinarySearch.medium;

public class kokoEatingBananas {
    
    public static void main (String args[]){

        int[] piles = {3,6,7,11};
        System.out.println(minEatingSpeed(piles, 8));
        // int[] piles = {312884470};
        // System.out.println(minEatingSpeed(piles, 312884469));
        // int[] piles = {1000000000};
        // System.out.println(minEatingSpeed(piles, 2));
        
    }

    // To make the code more memory-efficient, you can avoid pre-allocating the array k and instead dynamically determine the range of values to search for the optimal solution. Here's the modified version:
    public static int minEatingSpeed (int[] piles, int h){

        int max = Integer.MIN_VALUE;
        for (int i : piles) max = Math.max(max, i);
        
        int l = 1, k = 1, r = max;
        int res = max;
        while (l <= r) {

            k = l + (r-l)/2;
            
            int temp = 0;
            // System.out.println("k " + k);
            for (int i = 0; i < piles.length; i++) {
                temp = temp + (int)Math.ceil((double)piles[i]/k);
                if (temp > h) break;
                // System.out.println(temp);
            }
            
            if (temp <= h) {
                res = Math.min(res, k);
                r = k - 1;
                // System.out.println("break");
            }
            else l = k + 1;
        }
        
        return res;
    }

    // public static int minEatingSpeed (int[] piles, int h){

    //     // if (piles.length == 0) return 0; // Given in question
    //     // if (piles.length > h) return -1; // Given in question
    //     // if (piles.length == 1) return 1;
        
    //     int max = Integer.MIN_VALUE;
    //     for (int i : piles) max = Math.max(max, i);
    //     int[] k = new int[max];
    //     for (int i = 0 ; i < max ; i++) k[i] = i + 1;
        
    //     int l = 0, m = 0, r = k.length - 1;
    //     int res = Integer.MAX_VALUE;
    //     while (l <= r) {

    //         m = l + (r-l)/2;
            
    //         int temp = 0;
    //         // System.out.println("k[m] " + k[m]);
    //         for (int i = 0; i < piles.length; i++) {
    //             temp = temp + (int)Math.ceil((float)piles[i]/k[m]);
    //             if (temp > h) break;
    //             // System.out.println(temp);
    //         }
            
    //         if (temp <= h) {
    //             res = Math.min(res, k[m]);
    //             r = m - 1;
    //             // System.out.println("break");
    //         }
    //         else l = m + 1;
    //     }
        
    //     return res;
        
    // }
}
