package Solution;
import domain.ListNode;

import java.security.Key;

public class Solution0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=null;
        ListNode temp=null;
        boolean first=true;
        boolean end=false;
        while(cur!=null){
            next=cur;
            for (int i = 1; i < k; i++) {
                if(next.next==null){
                    end=true;
                    break;
                }
                next=next.next;
            }
            if(end)break;
            temp=next.next;
            next.next=pre;
            if(first){
                head=next;
                first=false;
            }
            ListNode pre1=pre;
            pre=cur;
            ListNode next1=null;
            while(cur!=null){
                if(cur==next.next){
                    break;
                }
                next1=cur.next;
                cur.next=pre1;
                pre1=cur;
                cur=next1;
            }
            pre.next=temp;
            cur=temp;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        Solution0025 solution0025 = new Solution0025();
        solution0025.reverseKGroup1(listNode1,2);
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=null;
        ListNode temp=null;
        boolean first=true;
        boolean end=false;
        while(cur!=null){
            next=cur;
            for (int i = 1; i < k; i++) {
                if(next.next==null){
                    end=true;
                    break;
                }
                next=next.next;
            }
            if(end){
                break;
            }
            temp=next.next;
            ListNode nextPre=cur;
            if(pre!=null) pre.next=next;
            while(cur!=temp){
                next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            nextPre.next=temp;
            if(first){
                head=pre;
                first=false;
            }
            pre=nextPre;
            cur=temp;
        }
        return head;
    }
}
