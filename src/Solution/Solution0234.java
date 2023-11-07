package Solution;

import domain.ListNode;

import java.util.ArrayList;

/**
 * @Classname Solution0234
 * @Description TODO
 * @Date 2023-11-3 18:16
 * @Created by ChenMX
 */
public class Solution0234 {

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        while(head!=null){
            integers.add(head.val);
            head=head.next;
        }

        boolean result=true;
        int middle = integers.size() / 2 + 1;
        for (int i = 0, j = integers.size()-1; i < middle; i++,j--) {
            if(!integers.get(i).equals(integers.get(j))){
                result=false;
            }
        }
        return result;
    }
}
