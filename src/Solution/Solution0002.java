package Solution;

import domain.ListNode;

/**
 * @author chenmx
 * @date 2026-4-7
 **/

public class Solution0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addFlag = 0;
        ListNode pre=new ListNode(0);
        ListNode head=pre;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1=l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2=l2.next;
            }
            int total = a + b + addFlag;
            int cur=0;
            if(total>=10){
                addFlag=1;
                cur=total-10;
            }else{
                addFlag=0;
                cur=total;
            }
            ListNode listNode = new ListNode(cur);
            head.next=listNode;
            head=head.next;
        }
        if(addFlag==1){
            head.next=new ListNode(1);
        }
        return pre.next;
    }


}
