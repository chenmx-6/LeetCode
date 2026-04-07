package Solution;

import domain.ListNode;

/**
 * @author Miles
 * @date 2025/11/5 22:27
 */
public class Solution0141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null){
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }else{
                return false;
            }
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }








    public boolean hasCycle2(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
            if(fast!=null){
                fast=fast.next;
            }else{
                return false;
            }
            if(fast==slow)return true;
        }
        return false;
    }
}
