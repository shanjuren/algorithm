package com.algorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * @author ght
 * @date 2022.04.13 5:09 PM
 * @description
 * 279. 完全平方数
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */
public class PerfectSquares {

    /**
     * 背包问题的变种，需要先找到背包物品的种类范围
     * 
     */
    
    public static int numSquares(int n) {
        int max = findN(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;

        for (int i = 1; i <= max; i++) {
            for (int j = i*i; j <= n; j++) {
                // 求最小值
                dp[j] = Math.min(dp[j],dp[j-(i*i)]+1);
            }
        }
        return dp[n]>n?0:dp[n];
    }

    public static int findN(int n) {
        int i=0;
        while (i*i<=n){
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.print(numSquares(10));
    }

}
