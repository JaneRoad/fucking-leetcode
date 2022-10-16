package linkedList;

import common.ListNode;

/**
 * 817. 链表组件
 *
 * @author janeroad
 */
public class LinkedListComponents {

    public int numComponents(ListNode head, int[] nums) {
        //题目限制链长不超过10000，题目限制每个head.val值唯一
        boolean[] flag = new boolean[10001];
        //判断哪个值有
        for (int num : nums) {
            flag[num] = true;
        }
        //pre记录前一个值存不存在,result记录链长
        int res = 0;
        boolean pre = false;
        while (head != null) {
            //如果前一个值不存在而当前遍历到的节点的值存在，则res+1
            if (!pre && flag[head.val]) {
                res++;
            }
            //记录当前遍历到的节点的值存在与否
            pre = flag[head.val];
            //继续遍历
            head = head.next;
        }
        return res;
    }
}
