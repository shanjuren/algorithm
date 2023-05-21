package com.algorithm.slidingWindow;

import java.util.LinkedList;

/**
 * @author ght
 * @date 2022.04.12 2:20 PM
 * @description
 *  滑动窗口内最大最小值之和
 */
public class SlidingWindowMaxMinSum {

    public static int[] sumMaxAndMin(int[] nums,int k){
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int[] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {

            while (!maxQueue.isEmpty() && maxQueue.peekLast()<nums[i]){
                maxQueue.pollLast();
            }
            while (!minQueue.isEmpty() && minQueue.peekLast()>nums[i]){
                minQueue.pollLast();
            }
            maxQueue.addLast(i);
            minQueue.addLast(i);

            if(i+1>=k){
                // 只有遍历到窗口周期时才进行运算
                result[i+1-k] = nums[maxQueue.peekFirst()]+nums[minQueue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = sumMaxAndMin(test,3);
        System.out.print(result);
    }
}
