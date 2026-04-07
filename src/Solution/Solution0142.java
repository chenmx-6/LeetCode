package Solution;

import domain.ListNode;

/**
 * @author chenmx
 * @date 2026-4-7
 **/

public class Solution0142 {
    public ListNode detectCycle(ListNode head) {
        //f=a+nb
        //s=c+mb
        //f=2s
        ListNode fast=head,slow=head;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
            if(fast!=null){
                fast=fast.next;
            }else{
                return null;
            }
            if(fast==slow){
                break;
            }
        }
        fast=head;
        while(slow!=null){
            if(slow==fast){
                return slow;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return null;
    }
}
