package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.25 5:02 PM
 * @description 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 */
public class Combinations {
    
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return result;
    }

    private void dfs(int start,int end, int length) {

        if(tmp.size()>length) return;

        for (int i = start; i <= end; i++) {
            tmp.add(i);
            dfs(i+1,end,length);
            if(tmp.size()==length){
                result.add(new ArrayList<>(tmp));
            }
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combine(4,2);
    }

}
