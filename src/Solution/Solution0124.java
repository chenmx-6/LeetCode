package Solution;

import domain.TreeNode;

import java.util.Map;

/**
 * @Classname Solution0124
 * @Date 2025-8-14 20:53
 * @Created by ChenMX
 */
public class Solution0124 {
    public  Map<TreeNode,Integer> fMap=new java.util.HashMap<>();
    public  Integer max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        maxPathSum(root.left);
        maxPathSum(root.right);
        Integer leftSingle =0;
        if(fMap.containsKey(root.left)){
            leftSingle=fMap.get(root.left);
        }
        Integer rightSingle = 0;
        if(fMap.containsKey(root.right)){
            rightSingle=fMap.get(root.right);
        }
        int maxSingle = Math.max(leftSingle, rightSingle);
        int singleValue = maxSingle + root.val;
        singleValue=Math.max(singleValue,root.val);
        fMap.put(root, singleValue);
        int totalValue = rightSingle+leftSingle + root.val;
        max=Math.max(totalValue,max);
        max=Math.max(singleValue,max);
        max=Math.max(root.val,max);
        return max;
    }

    public int maxPathSum2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftMax = maxPathSum2(root.left);
        int rightMax = maxPathSum2(root.right);
        int singleValue=Math.max(leftMax,rightMax)+root.val;
        int totalValue= leftMax+rightMax+root.val;
        max=Math.max(totalValue,max);
        max=Math.max(singleValue,max);
        max=Math.max(root.val,max);
        return max;
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        int i = new Solution0124().maxPathSum(node);
        System.out.println(i);
    }
}
