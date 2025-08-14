package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution0095
 * @Date 2025-8-7 11:28
 * @Created by ChenMX
 */
public class Solution0095 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] trees = new List[n+1];

        ArrayList<TreeNode> treeNodes0 = new ArrayList<>();
        TreeNode treeNode0 = null;
        treeNodes0.add(treeNode0);
        trees[0]=treeNodes0;

        ArrayList<TreeNode> treeNodes1 = new ArrayList<>();
        TreeNode treeNode1 = new TreeNode(1);
        treeNodes1.add(treeNode1);
        trees[1]=treeNodes1;
        for (int i = 2; i <= n; i++) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                List<TreeNode> leftTree = trees[j - 1];
                List<TreeNode> rightTree = trees[i - j];
                for (int k = 0; k <leftTree.size() ; k++) {
                    TreeNode leftNode = leftTree.get(k);
                    TreeNode leftClone = clone(leftNode, 0);
                    for (int l = 0; l < rightTree.size(); l++) {
                        TreeNode treeNode = new TreeNode(j);
                        TreeNode rightNode = rightTree.get(l);
                        treeNode.left=leftClone;
                        TreeNode rightClone = clone(rightNode, j);
                        treeNode.right=rightClone;
                        treeNodes.add(treeNode);
                    }
                }
            }
            trees[i]=treeNodes;
        }
        return trees[n];
    }

    public TreeNode clone(TreeNode treeNode,int difference){
        if(treeNode==null){
            return null;
        }
        TreeNode node = new TreeNode(treeNode.val + difference);
        node.left=clone(treeNode.left,difference);
        node.right=clone(treeNode.right,difference);
        return node;
    }

    public static void main(String[] args) {
        Solution0095 solution0095 = new Solution0095();
        List<TreeNode> treeNodes = solution0095.generateTrees(3);
        System.out.println(treeNodes);
    }
}
