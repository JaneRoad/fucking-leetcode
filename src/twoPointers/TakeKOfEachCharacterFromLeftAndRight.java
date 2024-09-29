package twoPointers;

/**
 * 2516. 每种字符至少取 K 个
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/27 06:37
 */
public class TakeKOfEachCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        // 统计字符 'a', 'b', 'c' 的总数
        int[] totalCount = new int[3]; // 0: 'a', 1: 'b', 2: 'c'
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // 如果任何一个字符的总数不足 k，返回 -1
        for (int count : totalCount) {
            if (count < k) {
                return -1;
            }
        }

        // 使用滑动窗口寻找最长的满足条件的子串
        int n = s.length();
        int[] windowCount = new int[3];
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // 扩展右边界
            windowCount[s.charAt(right) - 'a']++;

            // 检查当前窗口外的部分是否可以满足每个字符至少有 k 个
            while (windowCount[0] > totalCount[0] - k ||
                    windowCount[1] > totalCount[1] - k ||
                    windowCount[2] > totalCount[2] - k) {
                // 如果不满足条件，缩小左边界
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            // 记录当前窗口长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // 最少取出的字符数为字符串长度减去最长的满足条件的子串长度
        return n - maxLength;
    }
}
