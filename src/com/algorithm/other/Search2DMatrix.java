package com.algorithm.other;

/**
 * @author ght
 * @date 2022.05.03 4:34 PM
 * @description 74. 搜索二维矩阵
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int level = -1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][matrix[0].length-1]>=target){
                level = i;
                break;
            }
        }

        if(level==-1) return false;

        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[level][i]==target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3}};
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.print(search2DMatrix.searchMatrix(test,3));

    }

}
