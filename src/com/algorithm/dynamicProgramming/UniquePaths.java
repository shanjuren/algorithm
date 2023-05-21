package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.05 3:53 PM
 * @description
 * 62. 不同路径
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 */
public class UniquePaths {



    public static int uniquePaths(int m, int n) {
        int[][] already = new int[m][n];
       return findUniquePaths(already,m,n);
    }

    private static int findUniquePaths(int[][] already, int m, int n) {
        if(n<=0 || m<=0) return 0;
        if(m==1&&n==1){
            return 1;
        }
        if(already[m-1][n-1]>0){
            return already[m-1][n-1];
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }

//    /**
//     * 动态规划
//     * @param m
//     * @param n
//     * @return
//     */
//    public int uniquePaths(int m, int n) {
//        int[][] f = new int[m][n];
//        for (int i = 0; i < m; ++i) {
//            f[i][0] = 1;
//        }
//        for (int j = 0; j < n; ++j) {
//            f[0][j] = 1;
//        }
//        for (int i = 1; i < m; ++i) {
//            for (int j = 1; j < n; ++j) {
//                f[i][j] = f[i - 1][j] + f[i][j - 1];
//            }
//        }
//        return f[m - 1][n - 1];
//    }


    public static void main(String[] args) {
        System.out.print(uniquePaths(3,3));
    }

}
