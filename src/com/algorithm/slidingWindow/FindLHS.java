package com.algorithm.slidingWindow;

import java.util.Arrays;

/**
 * @description: 594. 最长和谐子序列
 * https://leetcode.cn/problems/longest-harmonious-subsequence/description/
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * @Author: ght
 * @Date: 2024/7/3 23:11
 */
public class FindLHS {

    /**
     * 题目中的不改变其余元素顺序是个误导条件，一旦可以去掉元素后，其实顺序已经无所谓，其实就是统计 n,n+1的数量之和
     * 滑动窗口或者暴力Hash算法都可以解决问题
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);

        int maxLength = Integer.MIN_VALUE, tmpLength = 0;

        for (int begin=0,end = 1; end < nums.length; end++) {
           if(nums[end]-nums[begin]==1){
               tmpLength = end-begin+1;
           } else if(nums[end]-nums[begin]>1){
               // 遇到不同的数字需要计算长度了
               maxLength = Math.max(maxLength,tmpLength);
               // 重新计算start位置
               while (nums[end]-nums[begin]>1){
                   begin++;
               }
           }
        }
        return Math.max(maxLength,tmpLength);
    }

    public static void main(String[] args) {
        FindLHS findLHS = new FindLHS();
        int[] nums = new int[]{1,2,2,1};
        System.out.println(findLHS.findLHS(nums));
    }
}
