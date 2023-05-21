package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.05 12:22 PM
 * @description 45. 跳跃游戏 II
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class JumpGameII {

    public static int jump(int[] nums){
        // 每次计算最远范围的边界值
        int end = 0;
        // 当前跳跃范围内最远可达距离
        int maxArrive = 0;
        // 具体跳跃次数
        int jumTimes = 0;
        // 挨个遍历过去，看看多少次可以循环走完
        for (int i = 0; i < (nums.length-1); i++) {
            maxArrive = Math.max(maxArrive,i+nums[i]);
            if(i==end){
                end=maxArrive;
                jumTimes++;
            }
        }
        return jumTimes;
    }


    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,1,4};
        System.out.printf(new Integer(jump(test)).toString()+"\n");
    }

}
