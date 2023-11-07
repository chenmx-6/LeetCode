import domain.ListNode;

/**
 * @Classname Offer24Solution
 * @Description TODO
 * @Date 2022-9-8 20:17
 * @Created by ChenMX
 */
public class Offer24Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
