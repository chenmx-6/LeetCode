package Solution;

import domain.ListNode;
import domain.Node;

import java.util.HashMap;

/**
 * @author Miles
 * @date 2026/3/7 22:32
 */
public class Solution0138 {
    public Node copyRandomList(Node head) {
        Node preHead = new Node(0);
        preHead.next=head;
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node currentPreHead =new Node(0);
        Node currentHead=currentPreHead;
        while(head!=null){
            Node node = new Node(head.val);
            nodeMap.put(head,node);
            currentHead.next=node;
            currentHead=currentHead.next;
            head=head.next;
        }
        head=preHead.next;
        currentHead=currentPreHead.next;
        while (head!=null){
            Node random = head.random;
            if(random!=null){
                Node node = nodeMap.get(random);
                currentHead.random=node;
            }
            head=head.next;
            currentHead=currentHead.next;
        }
        return currentPreHead.next;
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        ListNode cur=head;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
