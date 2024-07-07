package com.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 658. 找到 K 个最接近的元素
 * https://leetcode.cn/problems/find-k-closest-elements/description/
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 * @Author: ght
 * @Date: 2024/7/6 21:22
 */
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // 记录单调性，不用遍历所有的
        int tmp = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int begin=0,end = 0; end < arr.length; end++) {
            if(end<k){
                result.add(arr[end]);
                continue;
            }


            if(Math.abs(arr[begin]-x)>Math.abs(arr[end]-x)){
                // 移动窗口
                result.remove(0);
                result.add(arr[end]);
                begin++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        FindClosestElements elements = new FindClosestElements();
        System.out.println(elements.findClosestElements(arr,2,7));
    }

}
