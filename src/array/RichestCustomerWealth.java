package array;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) cur += accounts[i][j];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
