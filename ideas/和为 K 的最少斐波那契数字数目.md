# 题目

**类型：贪心**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1643906480671-31231667-c285-423a-b836-bfdf78276b9b.png)



# 解题思路

利用斐波那契数列的递推性质

和

凑成 k 的最优解中不包含重复数字的结论



凑成 k 的最优解中不包含重复数字：

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1643906901399-58f703c9-28ac-45bb-9367-6928d4469056.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1643906913678-fc574a34-d5f7-4e8c-80ad-d9f4688d79ca.png)

# 代码

```java
class Solution {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        while (b <= k) {
            int c = a + b;
            a = b; b = c;
        }
        int ans = 0;
        while (k != 0) {
            if (k >= b) {
                k -= b; ans++;
            }
            int c = b - a;
            b = a; a = c;
        }
        return ans;
    }
}
```