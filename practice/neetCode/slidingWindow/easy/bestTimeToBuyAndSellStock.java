package practice.neetCode.slidingWindow.easy;

public class bestTimeToBuyAndSellStock {

    public static void main (String args[]){

        int[] prices = {7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println(profit);
        
    }

    public static int maxProfit (int[] prices){

        // int min = Integer.MAX_VALUE, max = 0;
        // for (int i = 0; i < prices.length; i++){
        //     min = Math.min(min, prices[i]);
        //     max = Math.max(max, prices[i]-min);
        // }
        // return max;
        int right = 1, left = 0;
        int maxP = 0;
        int currP = 0;
        while (right < prices.length){

            if (prices[left] < prices[right]){
                currP = prices[right] - prices[left];
                maxP = Math.max(maxP, currP);
            }
            else{
                // left++;
                left = right;
            }
            right++;
        }
        return maxP;
    }
}
