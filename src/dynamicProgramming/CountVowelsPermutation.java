package dynamicProgramming;

/**
 * @Author JaneRoad
 * @Description 1220. 统计元音字母序列的数目
 * @Date 23:01 2022/1/17
 **/
public class CountVowelsPermutation {
    int MOD = (int)1e9+7;
    long[][] mul(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }
        return ans;
    }
    public int countVowelPermutation(int n) {
        long[][] ans = new long[][]{
                {1}, {1}, {1}, {1}, {1}
        };
        long[][] mat = new long[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0},
        };
        int x = n - 1;
        while (x != 0) {
            if ((x & 1) != 0) ans = mul(mat, ans);
            mat = mul(mat, mat);
            x >>= 1;
        }
        long sum = 0;
        for (int i = 0; i < 5; i++) sum += ans[i][0];
        return (int)(sum % MOD);
    }
}
