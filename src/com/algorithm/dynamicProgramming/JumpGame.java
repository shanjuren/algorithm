package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.05 3:28 PM
 * @description
 *  55. 跳跃游戏
 *  给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        if(nums[0]==0 || nums.length==0) return false;


        int end=0;
        int maxArrive=0;

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]==0){
                if(maxArrive<=i){
                    return false;
                }
            }else {
                maxArrive=Math.max(maxArrive,i+nums[i]);
                if(end == i){
                    end = maxArrive;
                }

            }

        }
        return maxArrive>=(nums.length-1)?true:false;

    }

    public static void main(String[] args) {
        int[] test = new int[]{2,5,0,0};
        System.out.print(canJump(test));
    }

}
