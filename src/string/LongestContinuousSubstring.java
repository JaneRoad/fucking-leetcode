package string;

/**
 * 2414. 最长字母序连续子字符串的长度
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/19 07:40
 */
public class LongestContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        // 边界情况，如果字符串为空或只有一个字符，直接返回长度
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 记录最长字母序连续子字符串的长度，最小值为1
        int maxLen = 1;
        // 当前字母序连续子字符串的长度
        int currentLen = 1;

        // 遍历字符串，从第二个字符开始
        for (int i = 1; i < s.length(); i++) {
            // 如果当前字符与前一个字符连续
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                // 当前连续长度加一
                currentLen++;
                // 更新最大长度
                maxLen = Math.max(maxLen, currentLen);
            } else {
                // 如果不连续，重置当前连续长度
                currentLen = 1;
            }
        }
        // 返回最长字母序连续子字符串的长度
        return maxLen;
    }

    public static void main(String[] args) {
        LongestContinuousSubstring solution = new LongestContinuousSubstring();
        System.out.println(solution.longestContinuousSubstring("abacaba"));  // 输出 2
        System.out.println(solution.longestContinuousSubstring("abcde"));    // 输出 5
    }
}
