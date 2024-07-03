package com.algorithm.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 219. 存在重复元素 II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * @Author: ght
 * @Date: 2024/7/1 22:04
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0 || nums.length==1){
            return false;
        }
        int end=1;
        Set<Integer> existNums = new HashSet<>();
        // 只要判断窗口内存在重复数字即可，窗口长度为k
        for (int i = 0; i < k; i++) {
            // 0~1是两个数
            if(i>k){
                // 窗口滑动
                existNums.remove(nums[i-k+1]);
            }
            if(!existNums.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        int k = 3;
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums,k));
    }
}
