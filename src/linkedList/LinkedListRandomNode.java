package linkedList;

import common.ListNode;

import java.util.Random;

/**
 * @Author JaneRoad
 * @Description 382. 链表随机节点
 **/
public class LinkedListRandomNode {
    ListNode head;
    Random random = new Random(20220116);
    public LinkedListRandomNode(ListNode _head) {
        head = _head;
    }
    public int getRandom() {
        int ans = 0, idx = 0;
        ListNode t = head;
        while (t != null && ++idx >= 0) {
            if (random.nextInt(idx) == 0) ans = t.val;
            t = t.next;
        }
        return ans;
    }
}
