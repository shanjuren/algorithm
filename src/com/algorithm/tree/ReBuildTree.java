package com.algorithm.tree;

/**
 * @author ght
 * @date 2022.04.26 4:55 PM
 * @description 889. 根据前序和后序遍历构造二叉树
 */

class TreeNode {
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
public class ReBuildTree {

    int preIndex=0;
    int postIndex =0;

    /**
     * 前序+后续
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);

        // 判断两边子树是否有相等的，如果节点没有相等的则继续深度遍历
        if (root.val != post[postIndex])
            root.left = constructFromPrePost(pre, post);
        // 这里判断是否有右子树，如果有的话再遍历右子树
        if (root.val != post[postIndex])
            root.right = constructFromPrePost(pre, post);

        // 两边子树都遍历完了或者都没有子树 当前pre当前节点一定等于post的当前节点
        postIndex++;
        return root;
    }

    /**
     * 前序+中序
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     *
     * @param preorder 前序遍历
     * @param p_start 前序遍历范围开始
     * @param p_end    前序遍历结束  通过中序遍历计算子树数量
     * @param inorder   中序遍历
     * @param i_start   中序遍历开始
     * @param i_end    中序遍历结束
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[]{4,5,2,6,7,3,1};
        ReBuildTree reBuildTree = new ReBuildTree();
        reBuildTree.constructFromPrePost(pre,post);
    }



}
