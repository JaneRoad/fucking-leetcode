package dynamicProgramming;

/**
 * 121. 买卖股票的最佳时机
 */
public class BestTimeToBuyAndSellStock {
    /**
     * 假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1] 之间选最低点买入；
     * 所以遍历数组，依次求每个卖出时机的的最大差值，再从中取最大值。
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
