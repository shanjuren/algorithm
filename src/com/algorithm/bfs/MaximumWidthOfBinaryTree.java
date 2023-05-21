package com.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ght
 * @date 2022.04.29 10:47 AM
 * @description 662. 二叉树最大宽度
 */
public class MaximumWidthOfBinaryTree {

    public static class TreeNode {
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

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> tmpQueue = new LinkedList<>();

        int maxLength = 0;

        tmpQueue.offer(root);

        while (!tmpQueue.isEmpty()){

            maxLength = Math.max(tmpQueue.size(),maxLength);

            int preNum = tmpQueue.size();
            boolean hasNext = false;
            for (int i = 1; i <= preNum; i++) {
                TreeNode nextNode = tmpQueue.poll();
                if(nextNode == null) continue;
                // 这里要判断下层是否至少有一个元素，如果有才能统计下一层
                if(nextNode.left!=null || nextNode.right!=null){
                    hasNext = true;
                }
                if(hasNext){
                    tmpQueue.offer(nextNode.left);
                    tmpQueue.offer(nextNode.right);
                }
            }

            if(!hasNext){
                break;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {

        /**
         *            1
         *          /   \
         *         3     2
         *        / \     \
         *       5   3     9
         */
        TreeNode test = new TreeNode(1,new TreeNode(3,new TreeNode(5),new TreeNode(3)),new TreeNode(2,null,new TreeNode(9)));
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        System.out.print(maximumWidthOfBinaryTree.widthOfBinaryTree(test)+"\n");
    }

}
