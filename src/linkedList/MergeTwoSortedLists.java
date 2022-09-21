package linkedList;

import common.ListNode;

/**
 * 21. 合并两个有序链表
 * @author janeroad
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                tmp.next = p2;
                p2 = p2.next;
            }else {
                tmp.next = p1;
                p1 = p1.next;
            }
            tmp = tmp.next;
        }

        if (p1 != null){
            tmp.next = p1;
        }
        if (p2 != null){
            tmp.next = p2;
        }

        return dummy.next;
    }
}
