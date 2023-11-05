

# 题目

**类型：**Linked List

**难度：**中等

![image-20210802203534534](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210802203534534.png)







# 解题思路

在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置。

https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/





# 代码

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
```



