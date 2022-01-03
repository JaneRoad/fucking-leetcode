package array;

public class Convert1DArrayInto2DArray {
    /**
     * @Author JaneRoad
     * @Description 2022. 将一维数组转变成二维数组
     * @Date 23:21 2022/1/2
     * @Param
     * @param original
     * @param m
     * @param n
     * @return
     * @return int[][]
     **/
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, ans[i / n], 0, n);
        }
        return ans;
    }
}
