package com.algorithm.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ght
 * @date 2022.05.03 8:43 AM
 * @description  56. 合并区间
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0]-o2[0];
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int[][] result = new int[intervals.length][2];
        int index = 0;


        for (int i = 1; i < intervals.length; i++) {
            if(right<intervals[i][0]){
                // 超出界限了，存个档
                result[index][0] = left;
                result[index++][1]  = right;
                // 重置当前区间
                left = intervals[i][0];
                right = intervals[i][1];
            }else if(left<=intervals[i][0] && right>=intervals[i][0]){
                // 没超出界限，继续扩边
                right = Math.max(intervals[i][1],right);
                left = Math.min(intervals[i][0],left);
            }
        }
        result[index][0] = left;
        result[index++][1]  = right;

        int[][] r = new int[index][2];
        for (int i = 0; i < index; i++) {
            r[i][0] = result[i][0];
            r[i][1] = result[i][1];
        }

        return r;
    }


    public static void main(String[] args) {
        int[][] test =new int[][]{{1,4},{0,4}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.print(mergeIntervals.merge(test));
    }
}
