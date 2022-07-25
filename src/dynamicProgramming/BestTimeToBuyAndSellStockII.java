package dynamicProgramming;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int length = prices.length, hold = Integer.MIN_VALUE, empty = 0, profit = 0;
        for (int i = 0; i < length; i++) {
            if (i - 1 <= -1) {
                hold = -prices[i];
                empty = 0;
                continue;
            }
            //持有 = 昨天持有 or 今天持有
            hold = Math.max(hold, -prices[i]);
            //没有 = 昨天没有 or 昨天有今天卖出
            empty = Math.max(empty, hold + prices[i]);
            //今天卖出结算利润
            if (empty == hold + prices[i]) {
                profit += empty;
            }
            //清空
            hold = -prices[i];
            empty = 0;
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(b.maxProfit(arr));
    }
}
