package Solution;

import domain.ListNode;

/**
 * @author Miles
 * @date 2026/4/6 1:15
 */
public class Solution0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        while(true){
            if(curA==curB)return curA;
            curA=curA.next;
            curB=curB.next;
            if(curA==null&&curB==null)break;
            if(curA==null){
                curA=headB;
            }
            if(curB==null){
                curB=headA;
            }
        }
        return null;
    }
}
