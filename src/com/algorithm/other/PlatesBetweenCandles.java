package com.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.27 5:26 PM
 * @description 2055. 蜡烛之间的盘子
 */
public class PlatesBetweenCandles {


    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candles = new ArrayList<>();
        int[] result = new int[queries.length];

        candles.add(-1);
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.charAt(i)=='|'){
                candles.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = getCandlesSum(s,candles,queries[i][0],queries[i][1]);
        }
        return result;
    }

    private int getCandlesSum(String s,List<Integer> candles, int start, int end) {

        int sum = 0;
        List<Integer> tmp = new ArrayList<>();
        boolean isFirst = true;
        for (int i = 1; i < candles.size(); i++) {
            if(candles.get(i)>=start && candles.get(i)<=end){
                if(isFirst){
                    isFirst=false;
                    continue;
                }
                // 先全部加进去，再算下头
                tmp.add(candles.get(i));
                sum+=(candles.get(i)-candles.get(i-1)-1);
            }
        }

        return sum;
    }

    /**
     * 正解
     * @param args
     */
//    public int[] platesBetweenCandles(String s, int[][] queries) {
//        int n = s.length();
//        int[] preSum = new int[n];
//        for (int i = 0, sum = 0; i < n; i++) {
//            if (s.charAt(i) == '*') {
//                sum++;
//            }
//            preSum[i] = sum;
//        }
//        int[] left = new int[n];
//        for (int i = 0, l = -1; i < n; i++) {
//            if (s.charAt(i) == '|') {
//                l = i;
//            }
//            left[i] = l;
//        }
//        int[] right = new int[n];
//        for (int i = n - 1, r = -1; i >= 0; i--) {
//            if (s.charAt(i) == '|') {
//                r = i;
//            }
//            right[i] = r;
//        }
//        int[] ans = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int[] query = queries[i];
//            int x = right[query[0]], y = left[query[1]];
//            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        String test = new String("***|**|*****|**||**|*");
        int[][] test1 = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        platesBetweenCandles.platesBetweenCandles(test,test1);
    }

}
