package com.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.28 10:25 AM
 * @description 103. 二叉树的锯齿形层序遍历
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result =new ArrayList<>();

        bfs(result,0,root,false);

        return result;
    }

    private void bfs(List<List<Integer>> result, int level, TreeNode root,boolean isPositive) {

        if(root==null) return;

        if(result.size()<=level && root!=null){
            result.add(new LinkedList<>());
        }

        LinkedList<Integer> curLevelList = (LinkedList<Integer>) result.get(level);
        if(isPositive){
            curLevelList.addFirst(root.val);
        }else {
            curLevelList.addLast(root.val);
        }

        bfs(result,level+1,root.left,!isPositive);
        bfs(result,level+1,root.right,!isPositive);
    }

    public static void main(String[] args) {
        // 3,9,20,null,null,15,7
        TreeNode test = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(test);
    }
}
