import domain.ListNode;

import java.util.Stack;

/**
 * @Classname Offer06Solution
 * @Description TODO
 * @Date 2022-9-8 19:42
 * @Created by ChenMX
 */
public class Offer06Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i]=stack.pop();
        }
        return result;
    }
}

