package com.algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.06 3:34 PM
 * @description
 * 120. 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10

 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] maxPath = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        int m = triangle.size();
        int maxColumns = triangle.get(m-1).size();
        maxPath[0][0] = triangle.get(0).get(0);

        // 跳过第一行
        for (int i = 1; i < m; i++) {
           List<Integer> row = triangle.get(i);
            int n=row.size();
            for (int j = 0; j < n; j++) {
                if(i==j){
                    maxPath[i][j] = maxPath[i-1][j-1]+triangle.get(i).get(j);
                    break;
                }else {
                    maxPath[i][j] = (j==0?maxPath[i-1][0]:Math.min(maxPath[i-1][j],maxPath[i-1][j-1]))+triangle.get(i).get(j);
                }
            }
        }
        int result = maxPath[m-1][0];
        for (int i = 1; i < maxColumns; i++) {
            if(maxPath[m-1][i]<result){
                result = maxPath[m-1][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3,4);
        List<Integer> row3 = Arrays.asList(6,5,7);
        List<Integer> row4 = Arrays.asList(4,1,8,3);
        test.add(row1);
        test.add(row2);
        test.add(row3);
        test.add(row4);
        System.out.print(minimumTotal(test));
    }

}
