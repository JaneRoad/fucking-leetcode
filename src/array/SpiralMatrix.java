package array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upperBound = 0, lowerBound = m - 1;
        int leftBound = 0, rightBound = n - 1;
        List<Integer> res = new LinkedList<>();
        // res.size() == m * n 则遍历完整个数组
        while (res.size() < m * n) {
            if (upperBound <= lowerBound) {
                // 在顶部从左向右遍历
                for (int j = leftBound; j <= rightBound; j++) {
                    res.add(matrix[upperBound][j]);
                }
                // 上边界下移
                upperBound++;
            }

            if (leftBound <= rightBound) {
                // 在右侧从上向下遍历
                for (int i = upperBound; i <= lowerBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                // 右边界左移
                rightBound--;
            }

            if (upperBound <= lowerBound) {
                // 在底部从右向左遍历
                for (int j = rightBound; j >= leftBound; j--) {
                    res.add(matrix[lowerBound][j]);
                }
                // 下边界上移
                lowerBound--;
            }

            if (leftBound <= rightBound) {
                // 在左侧从下向上遍历
                for (int i = lowerBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                // 左边界右移
                leftBound++;
            }
        }
        return res;
    }
}
