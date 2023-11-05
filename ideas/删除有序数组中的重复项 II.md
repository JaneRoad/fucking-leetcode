# 题目

![image-20210727002959687](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210727002959687.png)

# 解题思路

使用双指针法。

1、首先分析提议给定数组是有序的，所以相同元素必然连续。

2、定义两个指针分别为慢指针和快指针，其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度，即 nums[fast] 表示待检查的第一个元素，nums[slow−2] 为上一个应该被保留的元素所移动到的指定位置。

3、代码首先判断特殊情况，数组的前两个数必然可以被保留，因此对于长度不超过 2的数组，我们无需进行任何处理，直接返回结果。对于长度超过 2 的数组，我们直接将双指针的初始值设为 2 即可。

4、我们需要检查上上个应该被保留的元素 nums[slow−2] 是否和当前待检查元素 nums[fast] 相同。当且仅当nums[slow−2]=nums[fast] 时，当前待检查元素nums[fast] 不应该被保留（因为此时必然有 nums[slow−1]=nums[fast]）。最后，slow 即为处理好的数组的长度。

# 代码

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
```