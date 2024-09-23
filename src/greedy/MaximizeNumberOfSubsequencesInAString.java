package greedy;

/**
 * 2207. 字符串中最多数目的子序列
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/24 07:35
 */
public class MaximizeNumberOfSubsequencesInAString {
    /**
     * 计算通过添加一个字符能够最大化包含给定模式的子序列数量.
     *
     * 该方法通过遍历输入的文本，寻找可以形成给定模式的子序列，并计算这样的子序列数量。
     * 模式是一个由两个字符组成的字符串。我们关心的是通过在文本中添加一个字符能够形成的最大子序列数量。
     *
     * @param text 输入的文本字符串.
     * @param pattern 由两个字符组成的字符串，表示要寻找的模式.
     * @return 返回通过添加一个字符后能形成的最大子序列数量.
     */
    public long maximumSubsequenceCount(String text, String pattern) {
        // 初始化最终结果为0
        long res = 0;
        // 初始化两个计数器，分别用于统计模式的第一个字符和第二个字符出现的次数
        int cnt1 = 0, cnt2 = 0;

        // 遍历文本中的每个字符
        for (int i = 0; i < text.length(); ++i) {
            // 如果当前字符匹配模式的第二个字符
            if (text.charAt(i) == pattern.charAt(1)) {
                // 累加当前第一个字符出现次数到结果，表示可以形成的新子序列数量
                res += cnt1;
                // 增加第二个字符的计数
                cnt2++;
            }
            // 如果当前字符匹配模式的第一个字符
            if (text.charAt(i) == pattern.charAt(0)) {
                // 增加第一个字符的计数
                cnt1++;
            }
        }
        // 返回通过添加一个字符后能形成的最大子序列数量，考虑剩余的字符可以添加到开头或结尾的情况
        return res + Math.max(cnt1, cnt2);
    }
}
