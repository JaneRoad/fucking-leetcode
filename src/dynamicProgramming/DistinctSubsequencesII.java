package dynamicProgramming;

/**
 * 940. 不同的子序列 II
 * @author janeroad
 */
public class DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        int mod = (int)1e9 + 7;
        long result = 0L;
        // 记录26个字符每个字符的子序列总数
        long[] letter = new long[26];
        for (char sc : s.toCharArray()) {
            // 获得字符sc前一次统计的子序列数
            long pre = letter[sc - 'a'];
            // 计算当前字符sc的子序列数
            letter[sc - 'a'] = (result + 1) % mod;
            // 加mod的目的是为了防止结果溢出为负数
            result = (result + letter[sc - 'a'] - pre + mod) % mod;
        }
        return (int)result;
    }
}
