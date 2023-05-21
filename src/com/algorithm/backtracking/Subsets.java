package com.algorithm.backtracking;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.24 9:31 PM
 * @description
 * 78. 子集
 *
 * 回溯法
 */
public class Subsets {

    static List<Integer> tmp = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        dfs(0,nums);
        List<List<Integer>> test = new ArrayList<>(result);
        result.clear();
        tmp.clear();
        return test;
    }

    /**
     *
     * @param cur 当前元素所在的index,因为是不重复的子集所以按照集合中顺序向后遍历
     * @param nums
     */
    private static void dfs(int cur, int[] nums) {

        // 相等的话证明已经回溯到头，再往下没有元素了
        if(cur==nums.length){
            result.add(new ArrayList<>(tmp));
            return;
        }

        // 包含当前元素包含在内
        tmp.add(nums[cur]);
        dfs(cur+1,nums);
        tmp.remove(tmp.size()-1);
        // 不包含当前元素在内计算子集
        dfs(cur+1,nums);
    }


    public static void main(String[] args) {
        int[] test = new int[]{0};
        subsets(test);
    }
}
