package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Miles
 * @date 2025/10/12 20:33
 */
public class Solution0662 {
    public static int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        list.add(root);
        if(root==null){
            return 0;
        }
        HashMap<TreeNode, Long> map = new HashMap<>();
        map.put(root,0L);
        long maxWidth=1;
        while(list!=null&&list.size()!=0){
            ArrayList<TreeNode> subList = new ArrayList<>();
            long max=0;
            long min=0;
            for (TreeNode treeNode : list) {
                Long rootNum = map.get(treeNode);
                if(treeNode.left!=null){
                    subList.add(treeNode.left);
                    map.put(treeNode.left,(2*rootNum+1)%2147483645);
                    max=Long.max(max,2*rootNum+1);
                    if(min==0) min=2*rootNum+1;
                }
                if(treeNode.right!=null){
                    subList.add(treeNode.right);
                    map.put(treeNode.right,(2*rootNum+2)%2147483645);
                    max=Long.max(max,2*rootNum+2);
                    if(min==0)min=2*rootNum+2;
                }
                long thisLevelWidth = max - min+1;
                maxWidth=Long.max(maxWidth,thisLevelWidth);
            }
            list=subList;
        }
        return (int)(maxWidth);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        int i =widthOfBinaryTree(treeNode);
        System.out.println(i);
    }
}
