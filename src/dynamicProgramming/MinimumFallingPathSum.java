package dynamicProgramming;

/**
 * 931. 下降路径最小和
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        //1、初始化dp数组，dp数组用来存储当前位置的最小和
        int[][] dp = new int[matrix.length][matrix[0].length];
        //2、初始化返回值
        int res = Integer.MAX_VALUE;
        //3、遍历输入的二维数组
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //4、赋值当前遍历到的元素
                int cur = matrix[i][j];
                //5、如果第一行，dp的最小和就是元素本身
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                //6、如果非第一行，是最左列，dp的最小和就是两种答案比大小 （当前元素+上方）、（当前元素+右上方）
                } else if (j == 0) {
                    int upper = dp[i - 1][j];
                    int upperRight = dp[i - 1][j + 1];
                    dp[i][j] = Math.min(upper + cur, upperRight + cur);
                //7、如果非第一行，非最左列，是最右列，dp的最小和就是两种答案比大小 （当前元素+上方）、（当前元素+左上方）
                } else if (j == matrix[0].length - 1) {
                    int upper = dp[i - 1][j];
                    int upperLeft = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(upper + cur, upperLeft + cur);
                //8、如果非第一行，非第一列，非最右列，处于中间地带，dp的最小和就是三种答案比大小 （当前元素+左上方）、（当前元素+上方）、（当前元素+右上方）
                } else {
                    int upper = dp[i - 1][j];
                    int upperLeft = dp[i - 1][j - 1];
                    int upperRight = dp[i - 1][j + 1];
                    dp[i][j] = min(upper + cur, upperLeft + cur, upperRight + cur);
                }
            }
        }
        //9、遍历dp数组最下方一行，取最小值即为答案
        for (int j = 0; j < dp[0].length; j++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }

        return res;
    }


    public int min(int a, int b, int c) {
        int res = Math.min(a, b);
        res = Math.min(res, c);
        return res;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
        int[][] matrix = new int[][]{{-19, 57}, {-40, -5}};

        int i = minimumFallingPathSum.minFallingPathSum(matrix);
        System.out.println(i);
    }


}
