# 题目

**类型：Math**

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1638364367969-eb4de6ec-32b4-4f44-9709-0e4cfd1444bd.png)



# 解题思路

二分查找

为了得到无限整数序列中的第 n 位数字，需要知道第 n 位数字是哪一个整数的第几位。

如果知道第 n 位数字所在整数是几位数，就能计算得到第 n 位数字是哪一个整数的第几位。



假设第 n 位数字所在整数是 d 位数，则所有位数不超过 d - 1 的整数的位数之和小于 n，且所有位数不超过 d 的整数的位数之和大于等于 n。由于所有位数不超过 x 的整数的位数之和关于 x 单调递增，因此可以使用二分查找确定上述 d 的值。

对于某个 x，如果所有位数不超过 x 的整数的位数之和小于 n，则 d > x，否则 d≤x，以此调整二分查找的上下界。



由于任何整数都至少是一位数，因此 d 的最小值是 1。对于 d 的上界，可以通过找规律的方式确定。

- 1 位数的范围是 1 到 9，共有 9 个数，所有 1 位数的位数之和是 1×9=9。
- 2 位数的取值范围是 10 到 99，共有 90 个数，所有 2 位数的位数之和是 2×90=180。

- 3 位数的取值范围是 100 到 999，共有 900 个数，所有 3 位数的位数之和是 3×900=2700。
- ……



![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1638548218111-83491633-c751-466a-b028-fbeeb37213f8.png)

https://player.bilibili.com/player.html?bvid=BV13i4y1P7pX

# 代码

```java
class Solution {
    public int findNthDigit(int n) {
        int low = 1, high = 9;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int d = low;
        int prevDigits = totalDigits(d - 1);
        int index = n - prevDigits - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }
}
```