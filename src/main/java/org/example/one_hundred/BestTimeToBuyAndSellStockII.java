package org.example.one_hundred;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int index = 0;
        int profit = 0;
        while(index < prices.length) {
            while(index < prices.length - 1 && prices[index] > prices[index+1]) {
                index++;
            }
            int buyingPrice = prices[index++];
            while(index < prices.length - 1 && prices[index] < prices[index+1]) {
                index++;
            }
            if(index == prices.length) break;
            profit += prices[index] - buyingPrice;
        }
        return profit;
    }
}
