# 题目

**类型：**链表、递归

![img](https://cdn.nlark.com/yuque/0/2023/png/2941598/1678639284453-8236e137-a1fd-4aa0-8792-c4c1e2f9fd83.png)





# 解题思路

1. 链表是一种兼具递归和迭代性质的数据结构

1. a. 对这个链表调用 `reverseKGroup(head, 2)`，即以 2 个节点为一组反转链表

2. b. 如果设法把前 2 个节点反转，那么后面的那些节点怎么处理？后面的这些节点也是一条链表，而且规模（长度）比原来这条链表小，这就叫子问题

3. c. 可以把原先的 head 指针移动到后面这一段链表的开头，然后继续递归调用 `reverseKGroup(head, 2)`，因为子问题（后面这部分链表）和原问题（整条链表）的结构完全相同，这就是所谓的递归性质。

2. 发现了递归性质，就可以得到大致的算法流程

1. a. 先反转以 head 开头的 k 个元素。

2. b. 将第 k + 1 个元素作为 head 递归调用 reverseKGroup 函数。

3. c. 将上述两个过程的结果连接起来。

4. d. 递归函数都有个 base case。题目说了，如果最后的元素不足 k 个，就保持不变。这就是 base case

<img src="https://cdn.nlark.com/yuque/0/2023/gif/2941598/1678639966595-367ea80b-58c9-40e4-b54b-dd0308f1a74a.gif" alt="算法流程" style="zoom:25%;" />

3. 注意！ `reverse` 函数是反转区间 [a, b)，所以for 循环之后的几句代码的用处是这样的

<img src="https://cdn.nlark.com/yuque/0/2023/png/2941598/1678640218515-bce9ba05-3a22-42b9-9324-6e53e1568b92.png" alt="for循环后连接链表" style="zoom:25%;" />



4. 整个函数递归完成之后就是这个结果

<img src="https://cdn.nlark.com/yuque/0/2023/png/2941598/1678640277546-3647865c-1053-4730-80c0-709a4fb1a221.png" alt="结果" style="zoom:25%;" />



# 代码

```java
package linkedList;

import common.ListNode;

public class ReverseNodesInkGroup {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
```
