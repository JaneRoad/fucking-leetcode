# 题目

**类型：二分搜索**

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1638204059631-700b5327-f103-4408-b092-8b1d00054117.png)





# 解题思路

二分+双指针

（很难理解！以下为官方解答）

随便猜测一个实数 α，如果恰好有 k 个素数分数小于 α，那么这 k 个素数分数中最大的那个就是第 k 个最小的素数分数。



![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1638204390635-5ba018aa-e2df-4395-9112-b5f02138f5ef.png)



# 代码

```java
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;
        while (true) {
            //猜测可能的小数值
            double mid = (left + right) / 2;
            int i = -1, count = 0;
            // 记录最大的分数
            int x = 0, y = 1;

            //计算有多少个小数比它小
            //此处运用了分数的两个特性：
            //1. 分母不变，分子越大分数越大a[i+1]/a[j]>a[i]/a[j].对于分母固定的情况，当a[i]/a[j]>t时，必然满足a[i+1]/a[j]>t,即不可能在不改变分母的情况通过向又移动分子的方式找到小于t的值,此时需向右移动j寻找;
            //2. 分子不变，分母越大分数越小a[i]/a[j+1]<a[i]/a[j].也就是说对于a[i]/a[j],如果满足a[i]/a[j]<t，则一定有a[i]/a[j+1]<t，这意味着移动分母j后，分子指针i可以向右继续寻找,而无需从头查找;
            for (int j = 1; j < n; ++j) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    //记录最大值，其实也是特性，1/3<1/2,满足左上*右下<右上*左下
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }

            //刚好给出的小数，能刚好把分数分为[k个小于小数]小数[剩余大于小数]，则第k个一定是答案
            if (count == k) {
                return new int[]{x, y};
            }

            //特别注意，此处mid不要+1、-1，因为非整数，left/right不等的情况，等号赋值，不会出死循环
            //数量不足，说明猜测的实数小了，考虑更大值
            if (count < k) {
                left = mid;
            } else {
                //数量太多，说明猜测的实数大了，考虑更小值
                right = mid;
            }
        }
    }
}
```