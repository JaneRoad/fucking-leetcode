package array;

/**
 * 59. 螺旋矩阵 II
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upperBound = 0, lowerBound = n - 1;
        int leftBound = 0, rightBound = n - 1;
        // 需要填入矩阵的数字
        int num = 1;

        while (num <= n * n) {
            if (upperBound <= lowerBound) {
                // 在顶部从左向右遍历
                for (int j = leftBound; j <= rightBound; j++) {
                    matrix[upperBound][j] = num++;
                }
                // 上边界下移
                upperBound++;
            }

            if (leftBound <= rightBound) {
                // 在右侧从上向下遍历
                for (int i = upperBound; i <= lowerBound; i++) {
                    matrix[i][rightBound] = num++;
                }
                // 右边界左移
                rightBound--;
            }

            if (upperBound <= lowerBound) {
                // 在底部从右向左遍历
                for (int j = rightBound; j >= leftBound; j--) {
                    matrix[lowerBound][j] = num++;
                }
                // 下边界上移
                lowerBound--;
            }

            if (leftBound <= rightBound) {
                // 在左侧从下向上遍历
                for (int i = lowerBound; i >= upperBound; i--) {
                    matrix[i][leftBound] = num++;
                }
                // 左边界右移
                leftBound++;
            }
        }
        return matrix;
    }
}
