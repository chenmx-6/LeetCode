package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        int start=0;
        int end=0;
        while(treeNodes.size()>start){
            ArrayList<Integer> integers = new ArrayList<>();
            int add=0;
            for (int i = start; i <= end; i++) {
                TreeNode node = treeNodes.get(i);
                integers.add(node.val);
                if(node.left!=null){
                    treeNodes.add(node.left);
                    add++;
                }
                if(node.right!=null){
                    treeNodes.add(node.right);
                    add++;
                }
            }
            start=end+1;
            end=end+add;
            lists.add(integers);
        }
        return lists;
    }
}
