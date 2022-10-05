package twoPointers;

/**
 * 777. 在LR字符串中交换相邻字符
 *
 * @author janeroad
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while (i < n || j < n) {
            //在start字符串中，从左往右找到一个不是X的值
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }

            //在end字符串中，从左往右找到一个不是X的值
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }


            //判断是否有一个串遍历完成，而另一个串遍历没有完成的情况,
            // 如果出现了就只有两种结果：
            //      1.两个串都只有X 分两串长度相同和长度不相同
            //      2.其中一个串都是X，另一个串有一个其他字符
            //这两种情况都可以用i==j这个判断式来直接判断结果
            if (i == n || j == n) return i == j;


            //如果不相同则无法完成
            //例：
            // start: XXXXLXRXXXXX->XXXXXLRXXXXX  注:LR无法交换
            // end  : XXXXRXLXXXXX
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }


            //以start串的找到的值为例，如果是L,end串的L的索引则必须大于start串的L的索引
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }


            //如果是R,end串的R的索引则必须小于start串的R的索引
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }


            //其他情况可以完成交换，越过该次，进入下一次
            i++;
            j++;
        }

        return i == j;
    }
}
