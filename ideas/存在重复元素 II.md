# 题目

**类型：数组**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1642689565792-ca920ccc-d4af-4cc9-a810-2aa99f0b98b5.png)





# 解题思路

从前往后遍历 nums，同时使用 Set 记录遍历当前滑窗内出现过的元素。

假设当前遍历的元素为 nums[i]：

- 下标小于等于 k（起始滑窗长度还不足 k + 1）：将当前元素加入 Set 中；
- 下标大于 k：将上一滑窗的左端点元素 nums[i - k - 1] 移除，判断当前滑窗的右端点元素 nums[i] 是否存在 Set 中，若存在，返回 True，否则将当前元素 nums[i] 加入 Set 中。

重复上述过程，若整个 nums 处理完后仍未找到，返回 False

# 代码

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
```