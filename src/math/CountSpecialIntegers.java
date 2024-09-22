package math;

import java.util.HashSet;
import java.util.Set;

/**
 * 2376. 统计特殊整数
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/20 07:22
 */
public class CountSpecialIntegers {

    /**
     * 计算并返回小于或等于给定正整数n的特殊数的数量
     * 特殊数：正整数，数字不会重复
     *
     * @param n 给定的正整数
     * @return 返回小于或等于n的特殊数的数量
     */
    public int countSpecialNumbers(int n) {
        // 将n转换为字符串，以便逐位检查
        String numStr = Integer.toString(n);
        // 获取n的位数
        int length = numStr.length();

        // 初始化特殊数的计数
        int result = 0;

        // 计算位数小于n的特殊数的数量
        for (int i = 1; i < length; i++) {
            result += 9 * permute(9, i - 1);
        }

        // 统计比 n 位数少的特殊数字
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < length; i++) {
            // 将当前位的字符转换为整数
            int digit = numStr.charAt(i) - '0';
            // 从1（如果i=0）或0（如果i>0）到digit-1，检查每个数字
            for (int j = (i == 0 ? 1 : 0); j < digit; j++) {
                // 如果j不在used中，将特定位数的特殊数的数量累加到结果中
                if (!used.contains(j)) {
                    result += permute(9 - i, length - i - 1);
                }
            }
            // 如果digit已经在used中，说明n不是特殊数，跳出循环
            if (used.contains(digit)) break;
            // 将digit添加到used中
            used.add(digit);
        }

        // 如果used的大小等于n的位数，说明n是特殊数，将结果加1
        if (used.size() == length) {
            result++;
        }

        // 返回特殊数的总数
        return result;
    }


    /**
     * 计算从 m 个元素中选取 k 个元素的排列数
     *
     * @param m 总元素个数
     * @param k 选取的元素个数
     * @return 从 m 个元素中选取 k 个元素的排列数
     */
    private int permute(int m, int k) {
        // 初始化结果为1，用于累乘计算排列数
        int res = 1;
        // 遍历k次，每次累乘(m-i)，计算排列数
        for (int i = 0; i < k; i++) {
            // 将(m-i)累乘到res上，计算排列数
            res *= (m - i);
        }
        // 返回计算得到的排列数
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountSpecialIntegers().countSpecialNumbers(20));
    }
}
