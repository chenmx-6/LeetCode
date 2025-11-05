package Solution;

import domain.ListNode;

/**
 * @author Miles
 * @date 2025/11/5 22:06
 */
public class Solution0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=head;
        for (int i = 0; i < n; i++) {
            pre=pre.next;
        }
        ListNode cur=new ListNode(0);
        cur.next=head;
        head=cur;
        while(pre!=null){
            cur=cur.next;
            pre=pre.next;
        }
        cur.next=cur.next.next;
        return head.next;
    }
}
