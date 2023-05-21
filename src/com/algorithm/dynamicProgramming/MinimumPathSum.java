package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.06 9:56 AM
 * @description
 * 64. 最小路径和
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class MinimumPathSum {

//    public static int minPathSum(int[][] grid) {
//        return getCurrentLong(grid,grid.length-1,grid[0].length-1);
//    }

//    // 递归式写法-->会超出时间限制
//    public static int getCurrentLong(int[][] grid,int m,int n){
//        if(m<0||n<0){
//            return 0;
//        }
//        if(m==0&&n==0){
//            return grid[0][0];
//        }
//        int left = getCurrentLong(grid,m,n-1);
//        int up = getCurrentLong(grid,m-1,n);
//        if(left==0||up==0){
//            return left==0?(up+grid[m][n]):(left+grid[m][n]);
//        }else {
//            return Math.min(left,up)+grid[m][n];
//        }
//    }


    // 动态规划循环式写法，优化空间算法
    public static int minPathSum(int[][] grid) {

        int[] result = new int[grid.length];
        int m = grid.length;
        int n = grid[0].length;
        int minPathSum = 0;

        // 求最小因为int[][]初始化出来时均为0且题目中允许为0所以此时需要针对空白队列进行初始化，防止运算中直接使用初始化的值进行累加
        for (int i = 1; i < m; i++) {
            result[i] = 10000;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j-1<0){
                    result[j]+=grid[j][i];
                    continue;
                }
                result[j] = Math.min(result[j],result[j-1])+grid[j][i];
            }
        }
        return result[m-1];
    }

    public static void main(String[] args) {
//        int[][] test  = new int[][]{{1,2},{1,1}};
//        System.out.print(minPathSum(test));
        String test1 = "12345678";
    }

}
