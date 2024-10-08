package com.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 713. 乘积小于 K 的子数组
 * https://leetcode.cn/problems/subarray-product-less-than-k/description/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * @Author: ght
 * @Date: 2024/7/19 23:25
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        Integer tmpProduct = 1;
        int resultCnt = 0;
        for (int begin = 0, end = 0; end < nums.length; end++) {

            tmpProduct = tmpProduct * nums[end];
            while (end>=begin && tmpProduct >= k) {
                tmpProduct = tmpProduct / nums[begin];
                begin++;
            }
            resultCnt+= end - begin + 1;

        }
        return resultCnt;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK productLess = new NumSubarrayProductLessThanK();
        System.out.println(productLess.numSubarrayProductLessThanK(new int[]{1,2,3}, 7));
    }

}
