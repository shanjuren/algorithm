package com.algorithm.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.28 10:16 AM
 * @description 102. 二叉树的层序遍历
 */
public class BinaryTreeLevelOrderTraversal {


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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        bfs(result,0,root);
        return result;

    }

    private void bfs(List<List<Integer>> result, int level, TreeNode root) {

        if(result.size()<=level && root!=null){
            result.add(new ArrayList<>());
        }
        // 当前为空直接返回
        if(root == null) return;
        result.get(level).add(root.val);
        bfs(result,level+1,root.left);
        bfs(result,level+1,root.right);
    }

    public static void main(String[] args) {
        // 3,9,20,null,null,15,7
        TreeNode test = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        BinaryTreeLevelOrderTraversal test1 = new BinaryTreeLevelOrderTraversal();
        test1.levelOrder(test);
    }

}
