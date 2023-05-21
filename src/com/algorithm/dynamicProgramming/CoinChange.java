package com.algorithm.dynamicProgramming;

import javax.naming.CompositeName;
import java.util.Arrays;

/**
 * @author ght
 * @date 2022.04.12 8:30 PM
 * @description
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        // 从背包容量开始遍历
        int[] dp = new int[amount+1];
        // 初始化数据，比较的时候可以直接被覆盖
        Arrays.fill(dp,amount+1);
        // 第一个数字需要被初始化出来
        dp[0] = 0;
        // 物品总数
        int n = coins.length;
        // 第一个不用遍历
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                // 还有剩余的空间可以装
                if(i>=coins[j]){
                    // 放和不放需要选择一个最小值，
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }

        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static int coinChangeV2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static int coinChanageV3(int[] nums,int amount){
        int max = amount+1;
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);

        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(dp[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-nums[j]+1]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }



    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5};
        CompositeName c  = new CompositeName();
        System.out.print(coinChange(test,11));
    }

}
