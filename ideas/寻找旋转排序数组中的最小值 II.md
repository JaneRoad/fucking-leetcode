# 题目

**类型：二分查找**

**难度：困难**

![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1632057253453-15b14948-0c6e-45f7-bd42-7e5526f5335b-20210919230100377.png)

# 解题思路

和153题的区别在于可能存在重复的元素

当nums[pivot]==nums[high]。由于重复元素的存在，并不能确定 nums[pivot] 究竟在最小值的左侧还是右侧，因此不能莽撞地忽略某一部分的元素。唯一可以知道的是，由于它们的值相同，所以无论 nums[high] 是不是最小值，都有一个它的「替代品」nums[pivot]，因此可以忽略二分查找区间的右端点。





![img](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/1632058873308-9f7bc369-0593-4533-b946-ae0d961d3eca.png)





# 代码

```java
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
```