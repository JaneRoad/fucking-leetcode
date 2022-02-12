package array;

public class NumberOfRectanglesThatCanFormTheLargestSquare {
    /**
     * @Author JaneRoad
     * @Description 1725. 可以形成最大正方形的矩形数目
     * @Date 00:35 2022/2/4
     * @Param 
     * @param rectangles
     * @return 
     * @return int
     **/
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, maxLen = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0], w = rectangle[1];
            int k = Math.min(l, w);
            if (k == maxLen) {
                ++res;
            } else if (k > maxLen) {
                res = 1;
                maxLen = k;
            }
        }
        return res;
    }
}
