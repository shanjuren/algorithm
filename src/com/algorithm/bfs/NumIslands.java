package com.algorithm.bfs;

/**
 * @description: 200. 岛屿数量
 *https://leetcode.cn/problems/number-of-islands/
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 * @Author: ght
 * @Date: 2024/8/28 22:57
 */
public class NumIslands {

    private int islandsSum = 0;

    public int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean existIslands = bfs(grid,i,j);
                if(existIslands){
                    islandsSum++;
                }
            }
        }
        return islandsSum;
    }

    private boolean bfs(char[][] grid, int i, int j) {
        if(i<0|| j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] == '0' || grid[i][j] == '2'){
            return false;
        }

        grid[i][j] = '2';
        bfs(grid,i+1,j);
        bfs(grid,i-1,j);
        bfs(grid,i,j+1);
        bfs(grid,i,j-1);
        return true;
    }


}
