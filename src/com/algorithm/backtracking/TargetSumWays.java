package com.algorithm.backtracking;

/**
 * @description: 494. 目标和
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 * @Author: ght
 * @Date: 2024/7/1 11:54
 */
public class TargetSumWays {

    private Integer sum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return sum;
    }

    private void dfs(int[] nums, int target, int index, int tmpSum) {

        if(index==nums.length && tmpSum == target){
            sum+=1;
        }

        if(index==nums.length){
            return;
        }

        dfs(nums,target,index+1,tmpSum-nums[index]);
        dfs(nums,target,index+1,tmpSum+nums[index]);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        TargetSumWays targetSumWays = new TargetSumWays();
        System.out.println(targetSumWays.findTargetSumWays(nums,target));
    }

}
