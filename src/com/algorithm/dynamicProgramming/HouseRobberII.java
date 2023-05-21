package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.06 10:21 PM
 * @description
 *213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 示例1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int maxLength = nums.length;
        return Math.max(rob1(nums,0,maxLength-2),rob1(nums,1,maxLength-1));
    }

    public static int rob1(int[] nums,int start,int end) {
        int first=nums[start],second=Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int tmp = second;
            second = Math.max(second,first+nums[i]);
             first = tmp;
        }
        return second;
    }

    //正解
//    public int rob(int[] nums) {
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0];
//        } else if (length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
//    }
//
//    public int robRange(int[] nums, int start, int end) {
//        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
//        for (int i = start + 2; i <= end; i++) {
//            int temp = second;
//            second = Math.max(first + nums[i], second);
//            first = temp;
//        }
//        return second;
//    }

}
