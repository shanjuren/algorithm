package com.algorithm.monotonicStack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ght
 * @date 2022.04.14 3:20 PM
 * @description
 * 1856. 子数组最小乘积的最大值
 *
 * 一个数组的 最小乘积定义为这个数组中 最小值乘以数组的 和。
 *
 * 比方说，数组[3,2,5]（最小值是2）的最小乘积为2 * (3+2+5) = 2 * 10 = 20。
 * 给你一个正整数数组nums，请你返回nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 * 子数组 定义为一个数组的 连续 部分。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 *
 * 示例 2：
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 *
 * 示例 3：
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 */
public class MaximumSubarrayMinProduct {

    /**
     * 单调栈思想，寻找数组中每个元素当做最小值时子集的特征值（min*sum）
     * 重复数时后面重复的数字会覆盖前面的计算结果，保证最后一个计算的数据是正确的的即可
     * @param nums
     * @return
     */
    public static int   maxSumMinProduct(int[] nums) {
       // 先计算出一个阶梯数组，用来计算sum时可以变成O(n)
       long[] sums = new long[nums.length];
       sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        LinkedList<Integer> minTmp = new LinkedList();
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!minTmp.isEmpty() && nums[minTmp.peekLast()] >= nums[i]) {
                int tmpIndex = minTmp.pollLast();
                // 只用计算被踢出栈的元素和栈的上一个元素差值
                // 这里不能使用tmpIndex因为因为已经从当前节点前一个才算栈顶元素的边界
                long tmpSum = (minTmp.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[minTmp.peekLast()])) ;
                //                max = Math.max(max,(stackSize == 0 ? sums[i - 1] : (sums[i - 1] - sums[stack[stackSize - 1]])) * arr[j]);
                max = Math.max(max, tmpSum* nums[tmpIndex]);
            }
            minTmp.addLast(i);
        }
        // 如果还有没空的说明都是小的，需要单独把这些小的再计算出来

        while (!minTmp.isEmpty()) {
            int tmpIndex = minTmp.pollLast();
            // 这里使用tmpIndex是因为只需要计算当前元素距离最后一个元素的距离即可，因为全局都遍历完了，相当于右边为-1
            long tmpSum = (minTmp.isEmpty() ? sums[nums.length-1] : (sums[nums.length-1] - sums[minTmp.peekLast()])) ;
            //            max = Math.max(max,(stackSize == 0 ? sums[size - 1] : (sums[size - 1] - sums[stack[stackSize - 1]])) * arr[j]);
            max = Math.max(max, tmpSum* nums[tmpIndex]);

        }

        return (int)(max%1000000007);
    }


    /**
     * 单调栈 递增顺序，这样最后面的哪个数字一定是最小的数字
     *
     * 但是为什么要递增呢？递减不行吗？ 当然不行， 不递增在出栈时就找到两边的边界
     *
     * @param nums
     * @return
     */
    public static int maxSumMinProduct2(int[] nums) {

        if(nums == null || nums.length==0){
            return 0;
        }

        // 这里可以做优化，先计算出 宽度
        // 这里必须是long不然会有越界问题
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        // 开始遍历
        long maxSum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                // 出栈元素保持升序
                int tmpIndex = stack.pop();
                long tmpSum = sums[i - 1] - (stack.isEmpty() ? 0 : sums[stack.peek()]);
                long tmpProduct = tmpSum * nums[tmpIndex];
                maxSum = Math.max(tmpProduct,maxSum);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            // 剩下的都是小卡拉米
            int tmpIndex = stack.pop();
            long tmpSum = sums[nums.length-1] - (stack.isEmpty()?0:sums[stack.peek()]);
            long tmpProduct = tmpSum * nums[tmpIndex];
            maxSum = Math.max(tmpProduct,maxSum);
        }
        return (int) (maxSum % 1000000007);
    }


    public static void main(String[] args) {
        int[] test = new int[]{4,10,6,4,8,7,8,3,5,3,4,9,9,5,10,7,10,7,6,4};
        System.out.print(maxSumMinProduct(test)+"\n");
    }

}
