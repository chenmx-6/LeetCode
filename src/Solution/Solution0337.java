package Solution;

import domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution0337
 * @Date 2025-8-14 19:57
 * @Created by ChenMX
 */
public class Solution0337 {

    public int rob(TreeNode root) {
        TreeNode copy = copy(root);
        return copy.val;
    }

    public TreeNode copy(TreeNode node){
        if(node==null)return null;
        TreeNode leftCopy = copy(node.left);
        TreeNode rightCopy = copy(node.right);
        int leftSon=0;
        int leftLeft=0;
        int leftRight=0;
        if(leftCopy!=null){
            leftSon=leftCopy.val;
            if(leftCopy.left!=null){
                leftLeft=leftCopy.left.val;
            }
            if(leftCopy.right!=null){
                leftRight=leftCopy.right.val;
            }
        }
        int rightSon=0;
        int rightLeft=0;
        int rightRight=0;
        if(rightCopy!=null){
            rightSon=rightCopy.val;
            if(rightCopy.left!=null){
                rightLeft=rightCopy.left.val;
            }
            if(rightCopy.right!=null){
                rightRight=rightCopy.right.val;
            }
        }
        int grandTotal=leftLeft+leftRight+rightRight+rightLeft;
        int sonTotal=leftSon+rightSon;
        TreeNode copyNode = new TreeNode(Math.max(grandTotal + node.val, sonTotal));
        copyNode.left=leftCopy;
        copyNode.right=rightCopy;
        return  copyNode;
    }
}
