package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 */
public class SelfDividingNumbers {
    //存储自除数
    static List<Integer> list = new ArrayList<>();
    //存储自除数在list中的位置
    static int[] hash = new int[10010];
    //预处理10000个数字中的自除数
    static {
        for (int i = 1; i <= 10000; i++) {
            int cur = i;
            boolean ok = true;
            while (cur != 0 && ok) {
                int u = cur % 10;
                if (u == 0 || i % u != 0) {
                    ok = false;
                }
                cur /= 10;
            }
            if (ok) {
                list.add(i);
            }
            hash[i] = list.size() - 1;
        }
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        //如果left属于自除数，把结果赋值给idx，否则进入下一位
        int idx = list.get(hash[left]) == left ? hash[left] : hash[left] + 1;
        //如果idx在list范围内，且在right范围内，加入结果的list中
        while (idx < list.size() && list.get(idx) <= right) {
            ans.add(list.get(idx++));
        }
        return ans;
    }
}
