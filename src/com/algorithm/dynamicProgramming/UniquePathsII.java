package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.05 4:14 PM
 * @description
 * 63. 不同路径 II
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 */
public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // 实际存的是上次运算的值，之前的值均会被覆盖掉，m,n维度随便选但是选中后需要在内部遍历
        int[] result = new int[m];
        result[0] = obstacleGrid[0][0]==0?1:0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 这里要注意，二维数组的计量单位  obstacleGrid[行][列]
                if(obstacleGrid[j][i]==1){
                    result[j]=0;
                    continue;
                }

                if(j-1>=0 && obstacleGrid[i][j-1]==0){
                    result[j]+=result[j-1];
                }
            }
        }

        return result[m-1];
    }

    public static void main(String[] args) {

        int[][] test = new int[][]{{0,0}};
        System.out.print(uniquePathsWithObstacles(test));
    }



}
