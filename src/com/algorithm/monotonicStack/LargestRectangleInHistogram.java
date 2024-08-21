package com.algorithm.monotonicStack;

import java.util.Stack;

/**
 * @author ght
 * @date 2022.04.14 11:15 AM
 * @description
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 */
public class LargestRectangleInHistogram {

    /**
     * 1856的变种
     * @param height
     * @return
     */
    public static int largestRectangleArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int curIndex = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int curArea = (right - left - 1) * height[curIndex];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        // 还有未出栈的一些数字，说明这些数字水位都能到最后一位
        while (!stack.isEmpty()) {
            int curIndex = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = height.length;
            // 宽度的结算公式
            int curArea = (right - left - 1) * height[curIndex];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }


    public static void main(String[] args) {

        int[] test = new int[]{2,1,5,6,2,3};
        System.out.print(largestRectangleArea(test));
    }




}
