# 题目

**类型：Array**

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635252400805-4dcffa4e-9cdd-4fc6-84c1-7ddbbe57d112.png)



# 解题思路

使用单调栈+哈希表

倒序遍历 nums 2，并用单调栈中维护当前位置右边的更大的元素列表，从栈底到栈顶的元素是单调递减的。

每次移动到数组中一个新的位置 i，就将当前单调栈中所有小于nums 2[i] 的元素弹出栈，当前位置右边的第一个更大的元素即为栈顶元素，如果栈为空则说明当前位置右边没有更大的元素。随后我们将位置 i 的元素入栈。

将元素值与其右边第一个更大的元素值的对应关系存入哈希表。







# 代码

```java
 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
```