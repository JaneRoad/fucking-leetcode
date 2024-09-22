package dynamicProgramming;

/**
 * 1014. 最佳观光组合
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/23 07:32
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        // 初始化左端点的最大值
        int leftMax = values[0] + 0;

        for (int j = 1; j < values.length; j++) {
            // 计算当前对的最大得分
            int currentScore = leftMax + values[j] - j;
            maxScore = Math.max(maxScore, currentScore);

            // 更新左端点的最大值
            leftMax = Math.max(leftMax, values[j] + j);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] values = {1,2};
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(values));
    }
}
