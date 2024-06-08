package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description: 95. 不同的二叉搜索树 II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * @Author: ght
 * @Date: 2024/6/1 16:17
 */
public class DifferentSearchBinaryTree {


    /**
     * 利用二叉搜索树的特性：
     * 1、左子树不为空的话则左子树元素均小于根节点，右子树不为空话则右子树元素均大于根节点
     * 2、左子树的节点数量为[1.....i-1]，右子树的节点数量为[i+1....n]
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        // 这里要起始是1
        return  generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // 处理叶子节点
        if (start > end) {
            result.add(null);
            return result;
        }
        if(start == end){
            result.add(new TreeNode(start));
        }

        List<TreeNode> tmpResult = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTreeList = generateTrees(start, i - 1);
            List<TreeNode> rightTreeList = generateTrees(i + 1, end);

            for (int j = 0; j < leftTreeList.size(); j++) {
                for (int k = 0; k < rightTreeList.size(); k++) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = leftTreeList.get(j);
                    curNode.right = rightTreeList.get(k);
                    tmpResult.add(curNode);
                }
            }
        }
        return tmpResult;
    }

    public static void main(String[] args) {
       DifferentSearchBinaryTree binaryTree = new DifferentSearchBinaryTree();
       List<TreeNode> result = binaryTree.generateTrees(3);
       System.out.println(result);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
