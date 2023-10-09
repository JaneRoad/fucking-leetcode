package greedy;

import java.util.Arrays;

/**
 * 2578. 最小和分割
 */
public class SplitWithMinimumSum {
    public int splitNum(int num) {
        // 首先我们把所有的数字拆开，变成一个个的个位数
        char[] s = (num + "").toCharArray();
        // 然后排序
        Arrays.sort(s);
        // 因为是两和 所以我们用一个长度为2的数组存储
        int[] ans = new int[2];
        for (int i = 0; i < s.length; ++i) {
            // i&1 与运算，如果值是1那么返回1，如果是0就返回0，刚好适用我们的数组，0和1两个下标
            // 每次结果*10 是为了将数字加到尾巴上去  -'0'是为了将字符转成数字 ASCII码的知识
            ans[i & 1] = ans[i & 1] * 10 + s[i] - '0';
        }

        // 思路是这样的  4325 四位数，拆开，然后排序，得到2345
        // 那么 我们从左到右，依次将数字拼接起来，就能够得到最小的组合
        // [2,0]  剩下 3 4 5
        // [2,3]  剩下 4 5
        // [24,3] 剩下 5
        // [24,35] 没有了 结束
        // 24+35就是最小的组合数
        return ans[0] + ans[1];
    }

}
