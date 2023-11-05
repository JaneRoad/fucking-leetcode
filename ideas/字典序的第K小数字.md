# 题目

**类型：字典树**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1648045890690-556192ba-ede1-450b-9eba-e0d08db0394e.png)



# 解题思路

什么是字典序？

简而言之，就是根据数字的前缀进行排序，

比如 10 < 9，因为 10 的前缀是 1，比 9 小。

再比如 112 < 12，因为 112 的前缀 11 小于 12。



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1648046412110-ab23d267-cea2-4ce7-88a9-17cec9c3bedd.png)



可以将该过程分两步操作 :「确定前缀」和「从以某个前缀开始找目标值」。

int getCnt(int x, int limit)，该函数实现了统计范围 [1,limit] 内以 x 为前缀的数的个数。

有了该函数之后，可以从最小的前缀 1开始枚举，假设当前枚举到前缀 x，根据 cnt=getCnt(x,n) 与 k  的大小关系进行分情况讨论：

- cnt<k：说明所有以 x 为前缀的数组均可跳过，此时让 x 自增，k 减去 cnt。含义为从下一个「数值比 x 大」的前缀中找目标值；
- cnt⩾k：说明目标值前缀必然为 x，此时我们需要在以 x 为前缀的前提下找目标值。此时让 x 乘 10,k 减 1（代表跳过了 x 本身）。含义为从下一个「字典序比 x 大」的前缀中找目标值。

当 k=1  时，当前前缀 x 即是答案（含义为以 x 为前缀的所有数中，最小的数，也就是 x 本身）。



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1648047097350-527a9a3e-deb7-4fbc-a35d-987600076139.png)



# 代码

```java
class Solution {
    public int findKthNumber(int n, int k) {
        int ans = 1;
        while (k > 1) {
            int cnt = getCnt(ans, n);
            if (cnt < k) {
                k -= cnt; ans++;
            } else {
                k--; ans *= 10;
            }
        }
        return ans;
    }
    int getCnt(int x, int limit) {
        String a = String.valueOf(x), b = String.valueOf(limit);
        int n = a.length(), m = b.length(), k = m - n;
        int ans = 0, u = Integer.parseInt(b.substring(0, n));
        for (int i = 0; i < k; i++) ans += Math.pow(10, i);
        if (u > x) ans += Math.pow(10, k);
        else if (u == x) ans += limit - x * Math.pow(10, k) + 1;
        return ans;
    }
}
```