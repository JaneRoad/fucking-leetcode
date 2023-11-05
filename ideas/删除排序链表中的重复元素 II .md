# 题目

![image-20210727003021912](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210727003021912.png)

# 解题思路

1、首先由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，我们只需要对链表进行一次遍历，就可以删除重复的元素。又因为题目说要删除重复元素，所以头结点可能被删除，我们要额外使用一个哑节点（dummy node）指向链表的头节点。

2、我们从指针 cur 指向链表的哑节点，随后开始对链表进行遍历。如果当前 cur.next 与 cur.next.next 对应的元素相同，那么我们就需要将 cur.next 以及所有后面拥有相同元素值的链表节点全部删除。我们记下这个元素值 x，随后不断将 cur.next 从链表中移除，直到 cur.next 为空节点或者其元素值不等于 x 为止。此时，我们将链表中所有元素值为 x 的节点全部删除；

如果当前 cur.next 与 cur.next.next 对应的元素不相同，那么说明链表中只有一个元素值为 cur.next 的节点，那么我们就可以将cur 指向cur.next。

3、遍历完整个链表之后 return 哑节点的下一个节点。

4、需要注意 cur.next 以及cur.next.next 可能为空节点，如果不加以判断，可能会产生运行错误。

# 代码

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
```