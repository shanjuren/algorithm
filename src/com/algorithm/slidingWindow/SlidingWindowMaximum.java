package com.algorithm.slidingWindow;

import java.util.LinkedList;

/**
 * @author ght
 * @date 2022.04.12 10:59 AM
 * @description
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class SlidingWindowMaximum {

    /**
     * 可以过，但是超时了，时间复杂度O(n²)
     * @param args
     */
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length-k+1];
//
//        for (int i = 0; i < nums.length; i++) {
//            int end = i+k-1;
//            if(end>=nums.length){
//                break;
//            }
//            int tmpResult = findMax(nums,i,end);
//            result[i] = tmpResult;
//        }
//        return result;
//    }
//
//    private static int findMax(int[] nums, int start, int end) {
//        int max = nums[start];
//        for (int i = start+1; i <=end; i++) {
//            if(max<nums[i]){
//                max = nums[i];
//            }
//        }
//        return max;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length<k) return nums;

        LinkedList<Integer> queue = new LinkedList();
        int[] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {
            // 保证队列中始终是单调递减
            while (!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 只需要清除一次，因为最大数进队列时会把之前所有的数都清除掉，队列中该数后面的数index均是小于前面的数据
            if(queue.peek()<=(i-k)){
                queue.pollFirst();
            }
            //  只有符合窗口时才会保存结果
            if(i+1>=k){
                result[i+1-k] = nums[queue.peekFirst()];
            }
        }
        return result;
    }





    public static void main(String[] args) {
        int[] test = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.print(maxSlidingWindow(test,3));

    }

}
