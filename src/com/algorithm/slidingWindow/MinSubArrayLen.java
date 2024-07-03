package com.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * @Author: ght
 * @Date: 2024/7/1 17:20
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0 || s == 0) {
            return 0;
        }
        // 这里是子集，先找到最大的窗口在逐渐缩小窗口看是否符合条件，避免子集收到影响
        int minCount = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int tmpSum = 0;
        while (end < nums.length) {
            tmpSum += nums[end];
            // 大于目标值，减小窗口
            while(tmpSum>=s){
                minCount = Math.min(minCount,end-start+1);
                tmpSum -= nums[start];
                start++;
            }
            end++;
        }
        return minCount == Integer.MAX_VALUE ? 0: minCount;
    }

    public static void main(String[] args) {
        MinSubArrayLen subArrayLen = new MinSubArrayLen();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(subArrayLen.minSubArrayLen(15,nums));
    }

}
