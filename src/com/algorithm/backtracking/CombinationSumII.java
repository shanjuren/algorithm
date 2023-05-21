package com.algorithm.backtracking;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.25 7:56 PM
 * @description 40. 组合总和 II
 */
public class CombinationSumII {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return result;
    }

    private void dfs(int[] candidates, int cur, int target) {
        if(sum>target) return;

        while (cur<candidates.length){
            tmp.add(candidates[cur]);
            sum+=candidates[cur];
            dfs(candidates,cur+1,target);
            if(sum==target){
                result.add(new ArrayList<>(tmp));
            }
            tmp.remove(tmp.size()-1);
            sum-=candidates[cur];
            while (cur<(candidates.length-1) && candidates[cur]==candidates[cur+1]){
                cur++;
            }
            cur++;
        }

    }

    /**
     * 0-1背包   ???
     * @param candidates
     * @param target
     * @return
     */
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//
//        Map<Integer, Set<List<Integer>>> dp = new HashMap<>();
//
//        for (int i = 0; i <= target; i++) {
//            dp.put(i,new HashSet<>());
//        }
//
//        for (int i = 0; i < candidates.length; i++) {
//            for (int j = 1; j <= target; j++) {
//                if(candidates[i]==j){
//                    dp.get(j).add(Arrays.asList(candidates[i]));
//                }
//
//                if(candidates[i]<j && dp.get(j-candidates[i]).size()>0){
//                    Set<List<Integer>> tmpSet = new HashSet<>(dp.get(j-candidates[i]));
//                    for (List<Integer> preList : tmpSet) {
//                        List<Integer> curList = new ArrayList<>(preList);
//                        curList.add(candidates[i]);
//                        dp.get(j).add(curList);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(dp.get(target));
//    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] test = new int[]{10,1,2,7,6,1,5};
        combinationSumII.combinationSum2(test,8);
    }

}
