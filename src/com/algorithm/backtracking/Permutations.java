package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.25 10:19 PM
 * @description  46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class Permutations {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Boolean> used = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            used.add(false);
        }
        dfs(nums,0);
        return result;


    }

    private void dfs(int[] nums, int cur) {

        if(cur>=nums.length) return;
        int i = 0;
        while(i<(nums.length)){
            // 求排列组合需要额外处理两种情况 当前节点不允许重复，需要遍历当前节点前面的节点
            int tmpIndex = (cur+i)%nums.length;
            if(used.get(tmpIndex)) {
                i++;
                continue;
            }
            tmp.add(nums[tmpIndex]);
            used.set(tmpIndex,true);
            dfs(nums,cur+1);
            if(tmp.size()==nums.length){
                result.add(new ArrayList<>(tmp));
            }
            tmp.remove(tmp.size()-1);
            used.set(tmpIndex,false);
            i++;
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] test = new int[]{1,2,3};
        permutations.permute(test);
    }

}
