# 题目

**类型：**数组

![img](https://cdn.nlark.com/yuque/0/2023/png/2941598/1689493922570-9cdfd5da-7925-4652-82a2-379aeb191961.png)



# 解题思路

有了 https://www.yuque.com/janeroad/leetcode/apfsgcqhki3k2dik的铺垫，稍微改一下代码即可完成这道题





# 代码

~~~java

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
~~~

