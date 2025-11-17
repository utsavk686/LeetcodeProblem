class Solution {
    public int maxProfit(int[] prices) {

        // in this we can buy and sell only one time, so we are finding the best time to buy and sell the stock.
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit = prices[i]- buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
            else{
                buyPrice = prices[i];
            }
            
        }
        return maxProfit;
    }
}