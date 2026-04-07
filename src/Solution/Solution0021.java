package Solution;

import domain.ListNode;

/**
 * @author chenmx
 * @date 2026-4-7
 **/

public class Solution0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(0);
        ListNode head=pre;
        while(list1!=null||list2!=null){
            if(list1==null){
                head.next=list2;
                break;
            }
            if(list2==null){
                head.next=list1;
                break;
            }
            if(list1.val<= list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        return pre.next;
    }
}
