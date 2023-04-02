package prefixSum;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * @author janeroad
 */
public class RangeSumQuery2DImmutable {
    static class NumMatrix {
        /**
         * preSum[i][j] 记录矩阵 [0, 0, i, j] 的元素和
         */
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return;
            }
            int n = matrix[0].length;
            if (n == 0) {
                return;
            }
            // 构造前缀和矩阵
            preSum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 计算每个矩阵 [0, 0, i, j] 的元素和
                    preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
                }
            }
        }

        /**
         * 计算子矩阵 [x1, y1, x2, y2] 的元素和
         * @param x1
         * @param y1
         * @param x2
         * @param y2
         * @return
         */
        public int sumRegion(int x1, int y1, int x2, int y2) {
            // 目标矩阵之和由四个相邻矩阵运算获得
            return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] + preSum[x1][y1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}
