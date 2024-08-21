package com.algorithm.monotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 *
 * 提示：
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * @Author: ght
 * @Date: 2024/8/19 15:12
 */
public class DailyTemperatures {

    /**
     * 可以过但是超时了
     * @param temperatures
     * @return
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] result = new int[temperatures.length];
//
//        for (int i = 0; i < temperatures.length; i++) {
//
//            int tmpIndex = i+1;
//            while (tmpIndex< temperatures.length && temperatures[tmpIndex]<=temperatures[i]){
//                tmpIndex++;
//            }
//            result[i] = (tmpIndex>=temperatures.length)?0:tmpIndex-i;
//        }
//
//        return result;
//    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;

    }


    public static void main(String[] args) {
        DailyTemperatures temperatures = new DailyTemperatures();
        int[] result = temperatures.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        // 8,1,5,4,3,2,1,1,0,0
        System.out.println(result);
    }
}
