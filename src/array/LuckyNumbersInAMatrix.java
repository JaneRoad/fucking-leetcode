package array;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    int N = 55;
    int[] row = new int[N], col = new int[N];
    public List<Integer> luckyNumbers (int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            row[i] = 100001;
            for (int j = 0; j < m; j++) {
                row[i] = Math.min(row[i], mat[i][j]);
                col[j] = Math.max(col[j], mat[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = mat[i][j];
                if (t == row[i] && t == col[j]) ans.add(t);
            }
        }
        return ans;
    }
}
