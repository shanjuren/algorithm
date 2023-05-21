package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.13 4:59 PM
 * @description
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[]dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <3; j++) {
                if(i>=j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.print(climbStairs(3));
    }

}
