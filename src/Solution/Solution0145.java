package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @date 2026/3/22 23:35
 */
public class Solution0145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getSequence(root,list);
        return list;
    }

    public void getSequence(TreeNode root,List<Integer> list){
        if(root==null)return;
        getSequence(root.left,list);
        getSequence(root.right,list);
        list.add(root.val);
    }
}
