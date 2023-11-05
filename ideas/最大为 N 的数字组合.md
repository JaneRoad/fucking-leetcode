# 题目

**类型：动态规划**



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1666508663804-1f91eacd-c93f-4dd3-99b3-d3e7642a5e67.png)

# 解题思路

首先，根据题意，我们要计算出通过digits数组中数字的组合，可以生成的小于或等于给定整数n的正整数的个数。那么，我们可以根据两种情况进行分析：



- 【情况1】n的最高位不等于digits数组中任意数字。
- 【情况2】n的最高位等于digits数组中的某个数字。



针对于【情况1】，我们以digits = ["1","3","5","7"], n = 8321为例。由于n的最高位是8，它不在digits数组中，并且比任意一个digits数组中的数字都大，那么我们可以得出如下结论：



- 第1位（8） 可以拼装出的组合数量为：4^4种
- 第2位（3） 可以拼装出的组合数量为：4^3种
- 第3位（2） 可以拼装出的组合数量为：4^2种
- 第4位（1） 可以拼装出的组合数量为：4^1种



我们将这4位的每个组合种类数量进行相加，最终结果就是：4^4 + 4^3 + 4^2 + 4^1 = 340种。具体操作，如下图所示：



 ![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1666510514295-613cf6f4-06ba-4281-a75e-1abd01939525.png)





------

针对于【情况2】，我们以digits = ["1","3","5","7"], n = 5321为例。由于n的第1位是5，它并没有大于digits中的所有数字，所以，最高位的拼装数量就一定小于4^4。但是，对于后3位数字的拼装，是没有影响的，所以我们分为两个步骤进行统计：



- 【步骤1】首先：计算后3位拼装组合，即：4^3 + 4^2 + 4^1 = 84种
- 【步骤2】然后：计算第1位拼装组合，我们下面再具体分析计算。



由于n的第1位是5，它大于digits数组里的“1”和“3”，所以，针对第1位如果是“1”或“3”的话，最高位可以拼装的组合都是4^3种。



由于n的第1位是5，它等于digits数组里的“5”，针对这种情况，我们就需要再继续看它的下一位数字，即：n的第2位——数字3。



由于n的第2位是3，它大于digits数组里的“1”，所以，针对第2位如果是“1”的话，可以拼装的组合都是4^2种。



由于n的第2位是3，它等于digits数组里的“3”，针对这种情况，我们就需要再继续看它的下一位数字，即：n的第3位——数字2。

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1666510534714-832b5052-9c80-4f32-a411-4be904de8fa2.png)

















# 代码

```java
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] nc = String.valueOf(n).toCharArray();
        int result = 0, ncl = nc.length, dl = digits.length;
        // 先对【非最高位】的其他位，可组装的数字进行统计
        for (int i = 1; i < ncl; i++) {
            result += Math.pow(dl, i);
        }
        for (int i = 0; i < ncl; i++) {
            // 是否需要对比下一个数字
            boolean compareNext = false;
            for (String digit : digits) {
                // 将String转换为char
                char dc = digit.charAt(0);
                if (dc < nc[i]) {
                    result += Math.pow(dl, ncl - i - 1);
                } else {
                    if (dc == nc[i]) {
                        compareNext = true;
                    }
                    break;
                }
            }
            if (!compareNext) {
                return result;
            }
        }
        // 如果到最后1位依然满足compareNext，因为最后1位无法再向后对比了，所以最终结果+1
        return ++result;
    }
}
```