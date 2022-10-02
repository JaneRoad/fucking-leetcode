package linkedList;

import common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * @author janeroad
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        //1,4,5
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        //1,3,4
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        //2,6
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{a,b,c};
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode listNode = mergeKSortedLists.mergeKLists(lists);
    }
}
