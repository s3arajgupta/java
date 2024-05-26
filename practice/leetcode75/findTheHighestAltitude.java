package practice.leetcode75;

public class findTheHighestAltitude {

    public static void main(String[] args) {

        // int[] gain = {-5,1,5,0,-7};
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
        
    }

    public static int largestAltitude (int[] gain) {

        int sum = 0, max = 0;
        int r = 0;
        while (r < gain.length) {

            sum += gain[r];
            max = Math.max(max, sum);
            r++;

        }
        
        return max;
        
    }
    
}
