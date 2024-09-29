package queue;

/**
 * Description of the class or method.
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/29 10:43
 */
public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 遍历计算每个人所需时间
            if (i <= k) {
                res += Math.min(tickets[i], tickets[k]);
            } else {
                res += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return res;
    }
}
