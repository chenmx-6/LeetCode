package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @date 2026/3/22 23:29
 */
public class Solution0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        getSequence(root,list);
        return list;
    }


    public void getSequence(TreeNode node,List<Integer> list){
        if(node==null)return;
        getSequence(node.left,list);
        list.add(node.val);
        getSequence(node.right,list);
    }

}
