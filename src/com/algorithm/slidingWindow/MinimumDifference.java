package com.algorithm.slidingWindow;

import java.util.Arrays;

/**
 * @description: 1984. 学生分数的最小差值
 * https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
 *
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 *
 * 返回可能的 最小差值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [90], k = 1
 * 输出：0
 * 解释：选出 1 名学生的分数，仅有 1 种方法：
 * - [90] 最高分和最低分之间的差值是 90 - 90 = 0
 * 可能的最小差值是 0
 * 示例 2：
 *
 * 输入：nums = [9,4,1,7], k = 2
 * 输出：2
 * 解释：选出 2 名学生的分数，有 6 种方法：
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
 * - [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
 * 可能的最小差值是 2
 * @Author: ght
 * @Date: 2024/7/4 23:00
 */
public class MinimumDifference {

    public int minimumDifference(int[] nums, int k) {


        if(nums.length==0||nums.length==1 || nums.length<k){
            return 0;

        }

        Arrays.sort(nums);

        int minNums = Integer.MAX_VALUE;

        for (int start = 0,end = 1; end < nums.length; end++) {
            if(end-start+1<k){
                continue;
            }
            if(end-start+1>k){
                start++;
            }

            minNums = Math.min(minNums,nums[end]-nums[start]);
        }
        return minNums == Integer.MAX_VALUE ? 0 :minNums;
    }

    public static void main(String[] args) {
        MinimumDifference difference = new MinimumDifference();
        int[] nums = new int[]{87063,61094,44530,21297,95857,93551,9918};
        System.out.println(difference.minimumDifference(nums,6));
    }
}
