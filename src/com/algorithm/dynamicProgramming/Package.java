package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.04 8:39 PM
 * @description 0-1背包问题
 * 有N件物品和一个容量为V的背包。第i件物品的重量是w[i]，价值是v[i]。求解将哪些物品装入背包可使这些物品的重量总和不超过背包容量，且价值总和最大。
 *
 * 主要是得出状态转移方程
 */
public class Package {

    /**
     * 解决背包问题的递归函数
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKS(int[] w, int[] v, int index, int capacity) {

        //基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0)
            return 0;

        //不放第index个物品所得价值
        int res = solveKS(w, v, index - 1, capacity);

        //放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }
        return res;
    }

    /**
     * v1递归版本
     * @param w
     * @param v
     * @param C
     * @return
     */
    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        return solveKS(w, v, size - 1, C);
    }

    private static int[][] memo;

    /**
     * 解决背包问题的递归函数
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKSV2(int[] w, int[] v, int index, int capacity) {
        //基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0)
            return 0;

        //如果此子问题已经求解过，则直接返回上次求解的结果
        if (memo[index][capacity] != 0) {
            return memo[index][capacity];
        }

        //不放第index个物品所得价值
        int res = solveKS(w, v, index - 1, capacity);

        //放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }

        //添加子问题的解，便于下次直接使用
        memo[index][capacity] = res;

        return res;
    }

    /**
     * v2记忆化搜索
     * @param w
     * @param v
     * @param C
     * @return
     */
    public static int knapSackV2(int[] w, int[] v, int C) {
        int size = w.length;
        memo = new int[size][C + 1];
        return solveKSV2(w, v, size - 1, C);
    }

    /**
     * V3动态规划二维数组版本
     * @param w 重量集合
     * @param v 价值集合
     * @param C 背包总重量
     * @return
     */
    public static int knapSackV3(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[][] dp = new int[size][C + 1];

        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }

        //填充其他行和列
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }

        return dp[size - 1][C];
    }

    /**
     * V4动态规划空间优化版本
     * @param w 重量集合
     * @param v 价值集合
     * @param C 背包总重量
     * @return
     */
    public static int knapSackV4(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[] dp = new int[C + 1];

        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[i] = w[0] <= i ? v[0] : 0;
        }

        for (int i = 1; i < size; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }


    public static void main(String[] args){
        int[] w = {2,1,3,2};
        int[] v = {12,10,20,15};
        System.out.println(knapSackV4(w,v,5));
    }


}
