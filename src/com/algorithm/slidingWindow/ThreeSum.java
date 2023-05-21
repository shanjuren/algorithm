package com.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.12 10:20 AM
 * @description
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            // 最开始的数大于0就没有必要遍历了
            if(nums[i] > 0) return result;
            // 连续重复的数字没有必要遍历
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int first = i;
            int second = i+1;
            int third  =n-1;
            while (second<third){
                int tmpSum = nums[first]+nums[second]+nums[third];

                if(tmpSum==0){
                    // 刚好命中条件
                    List<Integer> tmpResult = new ArrayList<>();
                    tmpResult.add(nums[first]);
                    tmpResult.add(nums[second]);
                    tmpResult.add(nums[third]);
                    result.add(tmpResult);

                    // 寻找下一个组合需要跳过重复数

                    do{
                        ++second;
                    }while (second<third && nums[second-1]==nums[second]);
                    do{
                        --third;
                    }while (second<third && nums[third+1]==nums[third]);

                }else if(tmpSum<=0){
                    // 总数太小 左边+1
                    second++;
                }else {
                    // 总数太大 右边-1
                    third--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1,0,1,2,-1,-4};
        threeSum(test);
    }



}
