package org.ds.array.easy;

public class BestTimeToBuySellStock {
    static void main(){
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices1 = new int[]{7,6,4,3,1};
        IO.println(maxProfit(prices));
        IO.println(maxProfit(prices1));
    }

    static int maxProfit(int[] prices){
        int maxProfit = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;

        for (int i: prices) {
            if(minSoFar > i){
                minSoFar = i;
            }
            maxProfit = Math.max(maxProfit, i - minSoFar);
        }
        return maxProfit;
    }
}
