# 题目

**类型：Math**

**难度：中等**

![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1632837148388-8c1ac2bc-3d1c-45a7-8bb6-01f9d52a2d94.png)

# 解题思路

![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1632837864964-93f294da-14ab-4832-9f78-24e2b2ed3819.png)

# 代码



```java
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
```