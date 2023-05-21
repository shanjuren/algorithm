package com.algorithm.KMP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.15 4:23 PM
 * @description
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class BinaryTreeSubTree {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        List<Integer> str1s = new ArrayList<>();
        List<Integer> str2s = new ArrayList<>();
        getArray(A, str1s);
        getArray(B, str2s);

        if(str1s.size()==0 || str2s.size()==0) return false;
        int[] next = getNextArray(str2s);
        int i = 0;
        int j = 0;

        while (i < str1s.size() && j < str2s.size()) {
            if (str1s.get(i).equals(str2s.get(j))) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == str2s.size() ? true : false;
    }

    /**
     * 生成Next数组
     *
     * @param str2s
     * @return
     */
    private static int[] getNextArray(List<Integer> str2s) {

        if (str2s.size() == 1) {
            return new int[] { -1 };
        }
        int i = 2;
        int ctn = 0;
        int[] next = new int[str2s.size()];
        next[0] = -1;
        next[1] = 0;

        for (; i < next.length; i++) {
            if (str2s.get(i-1).equals(str2s.get(ctn))) {
                next[i++] = ++ctn;
            } else if (ctn > 0) {
                ctn = next[ctn];
            } else {
                i++;
            }
        }
        return next;
    }

    private static void getArray(TreeNode a,List<Integer> result) {

        if(a==null){ return;}

        result.add(a.val);
        getArray(a.left,result);
        getArray(a.right,result);
    }



    // [10,12,6,8,3,11]
    public static void main(String[] args) {
        TreeNode test =new TreeNode(10);
        test.left = new TreeNode(12);
        test.right = new TreeNode(6);
        test.right.left = new TreeNode(8);
        test.right.right = new TreeNode(3);
        test.left.right = new TreeNode(11);
        TreeNode test1 =new TreeNode(10);
        test1.left = new TreeNode(12);
        test1.right = new TreeNode(6);
        test1.right.left = new TreeNode(8);


        System.out.print(isSubStructure(test,test1));
    }




}


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

