package com.algorithm.bfs;

import java.util.*;

/**
 * @author ght
 * @date 2022.05.03 5:22 PM
 * @description 107. 二叉树的层序遍历 II
 */
public class BinaryTreeLevelOrderTraversalII {



    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue  = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tmpResult = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curNode = queue.poll();
                if(curNode==null) continue;
                tmpResult.add(curNode.val);
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
            if(tmpResult.size()==0) continue;
            result.add(tmpResult);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        binaryTreeLevelOrderTraversalII.levelOrderBottom(root);
    }

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
}
