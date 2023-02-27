class Solution {
    public int maxProfit(int[] prices) {
        int min_price = prices[0];
        int max_profit = 0;

        for (int num : prices) {
            min_price = Math.min(min_price, num);
            max_profit = Math.max(max_profit, num - min_price);
        }

        return max_profit;
    }
}