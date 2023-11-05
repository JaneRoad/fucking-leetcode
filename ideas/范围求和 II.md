# 题目

**类型：Array**



![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1636273307452-119b9698-b854-4c8a-9665-4d1660571a11.png)

# 解题思路

对于每一次操作，给定 (a,b)，会将矩阵中所有满足 0≤i<a 以及 0≤j<b 的位置 (i, j) 全部加上 1。

由于 a,b 均为正整数，那么 (0,0) 总是满足上述条件，并且最终位置 (0,0) 的值就等于操作的次数。

问题转换为：什么范围内的数与位置 (0,0) 上的值相等，即什么范围会被每一次操作所覆盖。

不难发现，在所有的  ops[i] 中的横纵坐标  (x,y) 与左上角 (0,0) 形成的区域面积可确保被每次操作覆盖， x∗y 即是答案。





# 代码

```java
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
```