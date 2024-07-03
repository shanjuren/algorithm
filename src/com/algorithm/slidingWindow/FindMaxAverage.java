package com.algorithm.slidingWindow;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description: 643. 子数组最大平均数 I
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * @Author: ght
 * @Date: 2024/7/1 22:48
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length ==1 ){
            return nums[nums.length-1];
        }
        int start = 0, end = 0;
        int tmpSum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (end < nums.length) {
            int round = end - start + 1;
            if ( round< k) {
                tmpSum += nums[end++];
                continue;
            } else if (round == k) {
                tmpSum += nums[end++];
            } else {
                tmpSum -= nums[start++];
                tmpSum += nums[end++];
            }
            maxSum = Math.max(maxSum, tmpSum);
        }
        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
        FindMaxAverage maxAverage = new FindMaxAverage();
        System.out.println(maxAverage.findMaxAverage(nums, 93));
    }

}
