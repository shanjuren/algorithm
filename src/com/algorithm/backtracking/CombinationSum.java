package com.algorithm.backtracking;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.25 5:34 PM
 * @description 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 示例2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * 完全背包的问题
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    int sum = 0;

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        dfs(candidates,0,target);
//        return result;
//    }
//
//    private void dfs(int[] candidates, int start, int target) {
//
//        if(sum>target) return;
//
//        for (int i = start; i < candidates.length; i++) {
//            tmp.add(candidates[i]);
//            sum+=candidates[i];
//            dfs(candidates,i,target);
//            if(sum==target){
//                result.add(new ArrayList<>(tmp));
//            }
//            sum-=candidates[i];
//            tmp.remove(tmp.size()-1);
//        }
//    }

    /**
     * 动态规划，完全背包问题
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Map<Integer, Set<List<Integer>>> tmpResult = new HashMap<>();

        for (int i = 0; i <= target; i++) {
            tmpResult.put(i,new HashSet<>());
        }

        for (int j = 0; j < candidates.length; j++) {
            for (int i = 1; i <= target; i++) {
                // 刚刚等于这个值
                if(i==candidates[j]){
                    // 刚刚放下
                    tmpResult.get(i).add(Arrays.asList(candidates[j]));

                }
                if(i>candidates[j] && tmpResult.get(i-candidates[j]).size()>0){
                    // 还有剩余空位，计算剩余空位的可能性
                    for (List<Integer> preResult : tmpResult.get(i - candidates[j])) {
                        List<Integer> curResult = new ArrayList<>(preResult);
                        curResult.add(candidates[j]);
                        tmpResult.get(i).add(curResult);
                    }
                }
            }
        }


        return new ArrayList<>(tmpResult.get(target));
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] test = new int[]{2,3,6,7};
        combinationSum.combinationSum(test,7);
    }
}
