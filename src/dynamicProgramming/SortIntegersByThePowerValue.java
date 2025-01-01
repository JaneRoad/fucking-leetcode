package dynamicProgramming;

import java.util.List;
import java.util.ArrayList;

 
class SortIntegersByThePowerValue {
  public int getKth(int lo, int hi, int k) {
    // 创建一个列表用于存储整数及其幂值
    List<int[]> powerList = new ArrayList<>();

    // 遍历范围 [lo, hi] 内的每个整数
    for (int i = lo; i <= hi; i++) {
        // 计算整数 i 的幂值，并将整数及其幂值存储到列表中
        powerList.add(new int[]{i, getPower(i)});
    }

    // 按照幂值排序，如果幂值相同则按整数大小排序
    powerList.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

    // 返回排序后列表中的第 k 个整数
    return powerList.get(k - 1)[0];
}

    /**
     * 计算整数 x 的幂值
     * @param x 整数 x
     * @return 整数 x 的幂值
     */
     private int getPower(int x) {
        int steps = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        SortIntegersByThePowerValue solution = new SortIntegersByThePowerValue();
        System.out.println(solution.getKth(12, 15, 2)); // 输出: 13
    }
}
