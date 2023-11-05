# 题目

**类型：字符串、双指针**





# 解题思路

每次移动要么是将 XL 变为 LX，要么是将 RX 变为 XR，而该两者操作可分别看做将 L 越过多个 X 向左移动，将 R 越过多个 X 向右移动。



因此在 start 和 end 中序号相同的 L 和 R 必然满足坐标性质：



- 序号相同的 L : start 的下标不小于 end 的下标（即 L 不能往右移动）
- 序号相同的 R : start 的下标不大于 end 的下标（即 R 不能往左移动）

其中「序号」是指在 LR 字符串中出现的相对顺序。





# 代码

```java
class Solution {
	public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while (i < n || j < n) {
            //在start字符串中，从左往右找到一个不是X的值
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            
            //在end字符串中，从左往右找到一个不是X的值
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
          
          
            //判断是否有一个串遍历完成，而另一个串遍历没有完成的情况,
            // 如果出现了就只有两种结果：
            //      1.两个串都只有X 分两串长度相同和长度不相同
            //      2.其中一个串都是X，另一个串有一个其他字符
            //这两种情况都可以用i==j这个判断式来直接判断结果
            if (i == n || j == n) return i == j;
          
          
            //如果不相同则无法完成
            //例：
            // start: XXXXLXRXXXXX->XXXXXLRXXXXX  注:LR无法交换
            // end  : XXXXRXLXXXXX
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            
            
            //以start串的找到的值为例，如果是L,end串的L的索引则必须大于start串的L的索引
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
          
          
            //如果是R,end串的R的索引则必须小于start串的R的索引
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
         
         
            //其他情况可以完成交换，越过该次，进入下一次
            i++;
            j++;
        }
      
        return i == j;
    }
}
```