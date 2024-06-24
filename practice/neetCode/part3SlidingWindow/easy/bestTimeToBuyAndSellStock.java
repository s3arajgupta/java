// dp question https://takeuforward.org/data-structure/stock-buy-and-sell-dp-35/ ?

package practice.neetCode.part3SlidingWindow.easy;

public class bestTimeToBuyAndSellStock {

    public static void main(String args[]) {

        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {

        // int min = Integer.MAX_VALUE, max = 0; // ninja DP-35
        // for (int i = 0; i < prices.length; i++){
        // min = Math.min(min, prices[i]);
        // max = Math.max(max, prices[i]-min);
        // }
        // return max;

        int right = 1, left = 0;
        int maxP = 0;
        int currP = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                currP = prices[right] - prices[left];
                maxP = Math.max(maxP, currP);
            } else {
                left = right;
            }
            right++;
        }
        return maxP;

    }

}
