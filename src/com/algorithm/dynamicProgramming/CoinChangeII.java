package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.13 11:16 AM
 * @description
 * 518. 零钱兑换 II
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2：
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 *
 * 示例 3：
 * 输入：amount = 10, coins = [10]
 * 输出：1
 */
public class CoinChangeII {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        int n = coins.length;
        dp[0] = 1;

        // 计算组合方式需要把硬币的遍历放在外层，为了防止存在重复的情况，硬币遍历只需要遍历一遍
        for (int i = 0; i < n; i++) {
            // j=coins[i] 此处是对于之前的优化，对于之前放不下的场景直接跳过；反正也是叠加
            for (int j = coins[i]; j <= amount; j++) {
                // 此处相比于背包问题只是求种类所以不用max或者min比较，直接无脑加即可
                dp[j] += dp[j-coins[i]];
            }
        }

        return dp[amount];
    }

    public static int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,2,5};
        System.out.print(change2(5,test)+"\n");
    }

}
