package practice.striversSDE180.arraysPart1;

public class stockBuyAndSell {

    public static void main (String args[]){

        int[] prices = {7,1,5,3,6,4};
        int res = stockBuyAndSellFunc(prices);
        System.out.println(res);        
    }

    static int stockBuyAndSellFunc(int[] prices){

        int max = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
            
        }

        return max;
    }
    
}
