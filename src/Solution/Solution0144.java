package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @date 2026/3/13 0:30
 */
public class Solution0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        getPreSequence(root,list);
        return list;
    }

    public void  getPreSequence(TreeNode node,List<Integer> list){
        if(node==null)return;
        list.add(node.val);
        getPreSequence(node.left,list);
        getPreSequence(node.right,list);
    }
}
