package com.algorithm.backtracking;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.26 11:08 AM
 * @description 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class PermutationsII {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,used);
        return result;
    }

    private void dfs(int[] nums, int cur,boolean[] used) {

        if(tmp.size()==nums.length) result.add(new ArrayList<>(tmp));

        int i = 0;
        // 最多遍历数组长度的次数，剪枝在中间进行
        while(i<nums.length){
            // 求排列组合需要额外处理两种情况 当前节点不允许重复，需要遍历当前节点前面的节点
            int tmpIndex = (cur+i)%nums.length;
            if(used!=null && used[tmpIndex]) {
                i++;
                continue;
            }
            // 这里不使用while的原因是因为全排列的问题，需要按照当前顺序往下遍历%的场景
            //保证在填第 idx\textit{idx}idx 个数的时候重复数字只会被填入一次即可。而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
            //这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
            // 通俗点理解就是 按顺序排后，前面的值和当前值相同，且前面的值还未使用说明前面的值已经参与了所有相同前缀的遍历，重点在于前缀相同不重复走下去，剪枝
            if(tmpIndex>0 && nums[tmpIndex]==nums[tmpIndex-1] && !used[tmpIndex-1]){
                i++;
                continue;
            }
//            while(i<(nums.length-1) && tmpIndex>0 && nums[tmpIndex]==nums[tmpIndex-1] && !used[tmpIndex-1]){
//                i++;
//            }
            // 剪枝失败，说明前缀都未遍历过
            tmpIndex = (cur+i)%nums.length;
            tmp.add(nums[tmpIndex]);
            used[tmpIndex] = true;
            dfs(nums,cur+1,used);
            tmp.remove(tmp.size()-1);
            used[tmpIndex] = false;
            i++;
        }
    }


//    public List<List<Integer>> permuteUnique(int[] nums) {
//        int len = nums.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//
//        // 排序（升序或者降序都可以），排序是剪枝的前提
//        Arrays.sort(nums);
//
//        boolean[] used = new boolean[len];
//        // 使用 Deque 是 Java 官方 Stack 类的建议
//        Deque<Integer> path = new ArrayDeque<>(len);
//        dfs(nums, len, 0, used, path, res);
//        return res;
//    }
//
//    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
//        if (depth == len) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < len; ++i) {
//            if (used[i]) {
//                continue;
//            }
//
//            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
//            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
//            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
//                continue;
//            }
//
//            path.addLast(nums[i]);
//            used[i] = true;
//
//            dfs(nums, len, depth + 1, used, path, res);
//            // 回溯部分的代码，和 dfs 之前的代码是对称的
//            used[i] = false;
//            path.removeLast();
//        }
//    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        int[] test = new int[]{1,1,2};
        permutationsII.permuteUnique(test);
    }

}
