package com.algorithm.monotonicStack;

import java.util.Stack;

/**
 * @author ght
 * @date 2022.04.14 5:49 PM
 * @description
 * 85. 最大矩形
 *
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {

        if(matrix==null || matrix.length==0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int maxArea =0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j]=='0'?0:(height[j]+1);
            }
            maxArea = findNextRowArea(height,maxArea);
        }
        return maxArea;
    }

    private static int findNextRowArea(int[] height, int maxArea) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int tmpIndex = stack.pop();
                // 此处注意，如果栈不为空一定要取栈内上一个元素的下标作为左边界进行结算
                int k = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - k - 1) * height[tmpIndex]);
            }
            stack.push(i);
        }
        // 剩余通过总长度来计算当前
        while (!stack.isEmpty()) {
            int tmpIndex = stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            maxArea = Math.max(maxArea,(height.length-k-1)*height[tmpIndex]);
        }
        return maxArea;
    }



    public static void main(String[] args) {
        char[][] test = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(maximalRectangle(test));

    }

}
