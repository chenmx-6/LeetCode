package hw;

import domain.ListNode;

/**
 * @author Miles
 * @date 2025/10/8 20:47
 */
public class Solution0930 {
    public ListNode copyList (ListNode head, int k) {
        // write code here
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        ListNode preHead=head;
        for (int i = 0; i < k; i++) {
            head=preHead;
            while (head != null) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
                head=head.next;
            }
        }
        return pre.next;


    }
}
