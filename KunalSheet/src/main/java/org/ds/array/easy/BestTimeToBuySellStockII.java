package org.ds.array.easy;

public class BestTimeToBuySellStockII {
    static void main(){
        int[] arr = new int[]{7,1,5,3,6,4};
        IO.println(maxProfit(arr));
    }

    static int maxProfit(int[] prices){
        int maxProfitSoFar = 0;
        for(int i =1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfitSoFar += prices[i] - prices[i-1];
            }
        }
        return maxProfitSoFar;
    }
}
