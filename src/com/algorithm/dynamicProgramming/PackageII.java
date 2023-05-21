package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.06 4:21 PM
 * @description
 * 完全背包
 * 有n中重量和价值分别为wi、vi（1<=i<=n)的物品，从这些物品中挑选总重量不超过w的物品，求出挑选物品总价值和最大的挑选方案，这里每种物品可以挑选多件。
 */
public class PackageII {

    public static int knapSackV3(int[] w, int[] v, int C){
        int n = w.length;

        // 里面存放已经计算过的第N个物品下剩余C空间的最大价值
        int[][] dp = new int[n+1][C+1];

        //初始化第一行
//        //仅考虑容量为C的背包放第0个物品的情况
//        for (int i = 0; i <= C; i++) {
//            dp[0][i] = w[0] <= i ? (dp[0][i-1]+v[0]) : 0;
//        }
        // 开始双层遍历，外层是物品决策的Index,内层是剩余背包空间
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                // 只存在两种情况 当前物品放或者不放

                // 默认先取上一个物品决策的最优解，即当前物品不放进去
                dp[i][j] = dp[i-1][j];

                // 计算当前物品放进去剩余空间是否>0
                if(j-w[i-1]>=0){
                    // 此处是区分0-1背包的关键点，0-1背包在找当前能放进去的场景下时是i-1，不算当前物品的，完全背包是i算上当前物品的
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-w[i-1]]+v[i-1]);
                }
            }
        }

        return dp[n][C];
    }

    public static int knapSackV4(int[] w, int[] v, int C){
        int n = w.length;

        int[] dp = new int[w.length+1];

        // 先遍历背包空间或者物品种类都是一样的,因为此处不考虑顺序
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i-w[j]>0){
                    dp[i] = Math.max(dp[i],dp[i-w[j]]+v[j]);
                }
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] v = new int[]{10,30,30};
        int[] w = new int[]{1,3,4};
        System.out.print(knapSackV3(w,v,4)+"\n");
    }


}
