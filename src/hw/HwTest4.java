package hw;

import domain.ListNode;
import domain.TreeNode;

public class HwTest4 {
    public static void main(String[] args) {
        HwTest4 hwTest4 = new HwTest4();
        hwTest4.link();
    }

    public void link(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right= new TreeNode(5);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right.right= new TreeNode(6);
        TreeNode cur=new TreeNode(0);
        TreeNode node = getNode(treeNode, cur);
        System.out.println(cur);
    }


    public TreeNode getNode(TreeNode node,TreeNode cur){
        TreeNode next = new TreeNode(node.val);
        cur.right=next;
        cur=next;
        if(node.left !=null){
            cur=getNode(node.left,cur);
        }
        if(node.right!=null){
            cur=getNode(node.right,cur);
        }
        return cur;
    }
}
