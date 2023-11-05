# 题目

**类型：二分搜索**

**难度：简单**

![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1631806072905-a716c583-d563-4c20-abe2-d697dae43605.png)

# 解题思路

## 方法一：袖珍计算器算法

![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1631806637446-d2a81c42-0627-42db-8966-74a254a0578c-20210917000308209.png)



## 方法二：二分查找

![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1631806950920-dc9b426e-5ba2-4825-a725-00325b9b3a04-20210917000302705.png)

# 代码

方法一：

```java
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
```

方法二：

```java
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
```