# 题目

**类型：双指针**



![img](https://cdn.nlark.com/yuque/0/2023/png/2941598/1673281247738-07dc04ad-e7e3-46ac-9aea-ddd07db6db7d.png)

# 解题思路

需要注意的是这题leetcode判定的index从1开始

# 代码

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            //先计算当前二元组的和
            int currSum = numbers[left] + numbers[right];
            //如果当前二元组的和小于目标值，或者左指针的值和上一个值相同，将左指针右移一位。
            if (currSum < target || (left > 0 && numbers[left] == numbers[left - 1])) {
                ++left;
                //如果当前二元组的和大于目标值，或者右指针的值和下一个值相同，则将右指针左移一位。
            } else if (currSum > target || (right < numbers.length - 1 && numbers[right] == numbers[right + 1])) {
                --right;
            } else {
               return new int[]{left+1, right+1};
            }
        }

        return null;
    }
}
```