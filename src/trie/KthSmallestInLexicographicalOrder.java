package trie;

/**
 * 440. 字典序的第K小数字
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int ans = 1;
        while (k > 1) {
            int cnt = getCnt(ans, n);
            if (cnt < k) {
                k -= cnt; ans++;
            } else {
                k--; ans *= 10;
            }
        }
        return ans;
    }
    int getCnt(int x, int limit) {
        String a = String.valueOf(x), b = String.valueOf(limit);
        int n = a.length(), m = b.length(), k = m - n;
        int ans = 0, u = Integer.parseInt(b.substring(0, n));
        for (int i = 0; i < k; i++) ans += Math.pow(10, i);
        if (u > x) ans += Math.pow(10, k);
        else if (u == x) ans += limit - x * Math.pow(10, k) + 1;
        return ans;
    }
}
