# 题目

![image-20210727002723443](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210727002723443.png)

# 解题思路

快慢指针法。

由于我们需要找到倒数第 n 个节点，初始时 first 和second 均指向头节点。我们首先使用first 对链表进行遍历，遍历的次数为 n。此时，first 和 second 之间间隔了 n−1 个节点，即first 比 second 超前了 n 个节点。

在这之后，我们同时使用 first 和 second 对链表进行遍历。当 first 遍历到链表的末尾（即 first 为空指针）时，second 恰好指向倒数第 n 个节点。

当 first 遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点。

# 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
```