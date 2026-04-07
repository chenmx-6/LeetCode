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

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast=head,slow=head;
        ListNode pre=new ListNode(0);
        ListNode curHead=pre;
        pre.next=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=slow.next;
        return curHead.next;

    }
}
