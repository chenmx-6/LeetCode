package Solution;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Miles
 * @date 2026/1/3 0:19
 */
public class Solution0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        HashMap<TreeNode, Integer> sequenceMap = new HashMap<>();
        sequenceMap.put(root,0);
        map.put(0,root);
        while(!treeNodes.isEmpty()){
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode treeNode : treeNodes) {
                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;
                if(left!=null){
                    nextLevel.add(left);
                    sequenceMap.put(left,sequenceMap.get(treeNode)*2+1);
                    map.put(sequenceMap.get(treeNode)*2+1,left);
                }
                if(right!=null) {
                    nextLevel.add(right);
                    sequenceMap.put(right, sequenceMap.get(treeNode) * 2 + 2);
                    map.put(sequenceMap.get(treeNode)*2+2,right);
                }
            }
            treeNodes=nextLevel;
        }
        Integer indexP = sequenceMap.get(p);
        Integer indexQ = sequenceMap.get(q);
        ArrayList<Integer> listP = new ArrayList<>();
        ArrayList<Integer> listQ = new ArrayList<>();
        while(indexP>=0){
            listP.add(0,indexP);
            if(indexP%2==0){
                indexP = (indexP - 2) / 2;
            }else{
                indexP = (indexP - 1) / 2;
            }
        }
        while(indexQ>=0){
            listQ.add(0,indexQ);
            if(indexQ%2==0){
                indexQ = (indexQ - 2) / 2;
            }else{
                indexQ = (indexQ - 1) / 2;
            }
        }
        int rootIndex=0;
        for (int i = 0; i < listP.size(); i++) {
            if(i>listQ.size()-1){
                break;
            }
            if(listP.get(i)==listQ.get(i)){
                rootIndex= listP.get(i);
            }else{
                break;
            }
        }

        return map.get(rootIndex);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        root.left=left;
        TreeNode right = new TreeNode(1);
        root.right=right;
        right.left=new TreeNode(0);
        right.right=new TreeNode(8);
        Solution0236 solution0236 = new Solution0236();
        solution0236.lowestCommonAncestor(root,right.left,right.right);
    }
}
