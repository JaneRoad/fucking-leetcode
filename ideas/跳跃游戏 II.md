# 题目

**类型：**动态规划

**难度：**中等



![image-20210821173829167](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210821173829167.png)





# 解题思路

1、这道题是典型的贪心算法，通过局部最优解得到全局最优解。

2、维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。

3、在遍历数组时，不访问最后一个元素，因为在访问最后一个元素之前，边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。













![image-20210821174053267](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210821174053267.png)







# 代码

```java
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
```

