package com.algorithm.recursion;

/**
 * @author ght
 * @date 2022.04.26 11:07 PM
 * @description 剑指 Offer II 105. 岛屿的最大面积
 */
public class AreaOfIsland {

    int maxArea = 0;
    int tmpArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                findMaxArea(grid,i,j);
                tmpArea=0;
            }
        }
        return maxArea;
    }

    private void findMaxArea(int[][] grid, int m, int n) {
        if(m<0 || m>=grid.length|| n<0 || n>=grid[0].length || grid[m][n]==2 || grid[m][n]==0) return;

        grid[m][n] = 2;
        tmpArea++;
        if(tmpArea>maxArea){
            maxArea = new Integer(tmpArea);
        }
        // 上
        findMaxArea(grid,m-1,n);
        // 下
        findMaxArea(grid,m+1,n);
        // 左
        findMaxArea(grid,m,n-1);
        // 右
        findMaxArea(grid,m,n+1);
    }

    public static void main(String[] args) {
        AreaOfIsland areaOfIsland  = new AreaOfIsland();
        int[][] test = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.print(areaOfIsland.maxAreaOfIsland(test)+"\n");
    }


}
