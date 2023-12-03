package prefixSum;

public class MaximumPointsYouCanObtainFromCards {


    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // 计算前缀和数组
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + cardPoints[i - 1];
        }

        // 滑动窗口找到长度为 n - k 的子数组的最小值
        int windowSize = n - k;
        int totalSum = prefixSum[n];
        int minWindowSum = Integer.MAX_VALUE;

        for (int i = 0; i <= n - windowSize; i++) {
            int currentWindowSum = prefixSum[i + windowSize] - prefixSum[i];
            minWindowSum = Math.min(minWindowSum, currentWindowSum);
        }

        // 最大点数为总和减去最小子数组的和
        return totalSum - minWindowSum;

    }

    public static void main(String[] args) {
        // 示例测试
        int[] cardPoints1 = {1, 6, 0, -5, 45, 1};
        int k1 = 3;
        System.out.println(maxScore(cardPoints1, k1)); // 输出：12

        int[] cardPoints2 = {2, 2, 2};
        int k2 = 2;
        System.out.println(maxScore(cardPoints2, k2)); // 输出：4

        int[] cardPoints3 = {9, 7, 7, 9, 7, 7, 9};
        int k3 = 7;
        System.out.println(maxScore(cardPoints3, k3)); // 输出：55

        int[] cardPoints4 = {1, 1000, 1};
        int k4 = 1;
        System.out.println(maxScore(cardPoints4, k4)); // 输出：1

        int[] cardPoints5 = {1, 79, 80, 1, 1, 1, 200, 1};
        int k5 = 3;
        System.out.println(maxScore(cardPoints5, k5)); // 输出：202
    }
}
