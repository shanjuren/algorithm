package com.algorithm.backtracking;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.25 3:24 PM
 * @description
 * 90. 子集 II
 */
public class SubsetsII {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return result;
    }

    private void dfs(int[] nums, int current) {

        result.add(new ArrayList<>(tmp));

       while(current<nums.length){
           // 先无脑加进去
           tmp.add(nums[current]);
           // 深度往下走
           dfs(nums,current+1);
           // 回溯，先去除掉最后一个元素
           tmp.remove(tmp.size()-1);
           // 去重，遇到和后一个重复的直接取最后一个的重复的位置的子集
           while (current<(nums.length-1) && nums[current]==nums[current+1]){
               current++;
           }
           current++;
       }



    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);//排序
//        choose(nums, 0);
//        return ans;
//    }
//
//    public void choose(int[] nums, int index) {
//        //一开始会加入[],后面会保证list始终不为空
//        ans.add(new ArrayList<Integer>(list));
//
//        /*
//            多少个不同的元素，决定有几个子集合，或者几个层，
//            每一层中允许有子集合，因为要穷举子集
//        */
//        while (index < nums.length) {
//            list.add(nums[index]);
//            //深搜
//            choose(nums, index + 1);
//            //回溯
//            list.remove(list.size() - 1);
//            //去重
//            while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
//                index++;
//            }
//            index++;
//            //开始新的循环即意味着找子集合
//        }
//
//    }



    public static void main(String[] args) {
       int[] test = new int[]{1,2,2,3,4};
       SubsetsII subsetsII = new SubsetsII();
       subsetsII.subsetsWithDup(test);
    }

}
