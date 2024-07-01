package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 *
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 *
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 *
 *
 * 提示:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 *
 * @Author: ght
 * @Date: 2024/7/1 16:16
 */
public class CombinationSum3 {
    List<List<Integer>> exist = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<String> existRecords = new ArrayList<>();
        boolean[] used = new boolean[10];
        dfs(0,k,0,n,existRecords,used);
        return exist;
    }

    private void dfs(int index, int maxIndex,int tmpSum, int sum, List<String> existRecords, boolean[] used) {
        if (index > maxIndex || tmpSum>sum) {
            return;
        }

        if (index == maxIndex && tmpSum==sum) {
            String tmp = "";
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 1; i < used.length; i++) {
                if(used[i]){
                    tmp = tmp+i;
                    tmpList.add(i);
                }
            }
            if(existRecords.contains(tmp)){
                return;
            }else {
                existRecords.add(tmp);
                exist.add(tmpList);
            }
        }

        // 继续遍历
        for (int i = 1; i <= 9; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            dfs(index+1,maxIndex,tmpSum+i,sum,existRecords,used);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        CombinationSum3 sum3 = new CombinationSum3();
        System.out.println(sum3.combinationSum3(3,9));
    }

}
