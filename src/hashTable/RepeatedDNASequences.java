package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187 重复的DNA 序列
 * @author janeroad
 */
public class RepeatedDNASequences {
    // 定义动态规划数组。1e5+10是数学中的一种表示方法，它表示1万乘以10再加上10。
    static int N = (int)1e5+10;

    //这是一个质数，用于计算哈希值。每次计算都会将前一个字符的哈希值乘以131313，并加上当前字符的ASCII码。这样就可以得到当前位置的哈希值。
    // 使用质数作为乘法因子可以避免出现哈希值为0的情况。
    // 在计算哈希值时，还需要记录每个哈希值出现的次数，以便后续判断是否有重复的子序列。
    static int P = 131313;

    // h数组用于保存根据DNA序列计算得到的哈希值。在计算哈希值时
    // 每次将前一个字符的哈希值乘以一个质数（131313），然后加上当前字符的ASCII码，得到当前位置的哈希值。h数组的每个元素表示对应位置的哈希值
    int[] h = new int[N];

    //p数组用于保存计算哈希值时的当前索引值。在每次计算哈希值时，p数组的当前索引值表示从起始位置到当前位置的DNA序列的长度。
    // 在计算下一个位置的哈希值时，会使用p数组的当前索引值。p数组的每个元素表示对应位置的当前索引值。
    int[] p = new int[N];

    public List<String> findRepeatedDnaSequences(String s) {
        // 计算DNA序列的长度
        int n = s.length();
        // 创建一个答案列表
        List<String> ans = new ArrayList<>();
        // 初始化p数组的第一个元素为1
        p[0] = 1;
        // 根据DNA序列计算哈希值
        for (int i = 1; i <= n; i++) {
            // 计算哈希值h[i]
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            // 计算p数组的当前索引值
            p[i] = p[i - 1] * P;
        }
        // 创建一个哈希记录集合n
        Map<Integer, Integer> map = new HashMap<>();
        // 大小为 10 的滑动窗口，查找重复的子序列
        for (int i = 1; i + 10 - 1 <= n; i++) {
            // 根据公式hash = h[j] - h[i-1] * p[j-i+1]来计算子序列哈希值
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            // 获取哈希值的出现次数，如果出现两次则添加到答案列表中
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, i + 10 - 1));
            // 记录哈希值的出现次数
            map.put(hash, cnt + 1);
        }
        // 返回答案列表
        return ans;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences(s));
    }
}
