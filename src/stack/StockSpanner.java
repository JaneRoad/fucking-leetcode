package stack;

import java.util.Stack;

/**
 * 901. 股票价格跨度
 */
public class StockSpanner {
    // int[] 记录 {价格，小于等于该价格的天数} 二元组
    Stack<int[]> stk = new Stack<>();

    public int next(int price) {
        // 算上当天
        int count = 1;
        // 单调栈模板
        while (!stk.isEmpty() && price >= stk.peek()[0]) {
            // 挤掉价格低于 price 的记录
            int[] prev = stk.pop();
            // 计算小于等于 price 的天数
            count += prev[1];
        }
        stk.push(new int[]{price, count});

        return count;
    }
}
