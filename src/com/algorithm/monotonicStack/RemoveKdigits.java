package com.algorithm.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 402. 移掉 K 位数字
 * https://leetcode.cn/problems/remove-k-digits/description/
 * <p>
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零  // 059->59  001->1
 * @Author: ght
 * @Date: 2024/8/19 09:41
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {

        if (num.length() < k) {
            return "0";
        }
        char[] numChars = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(numChars[0]);
        for (int i = 1; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > numChars[i] && k > 0) {
                // 栈内最近的一个大于当前值需要退出
                stack.pop();
                k--;
            }
            stack.push(numChars[i]);
        }

        // 剪裁多余的元素
        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        builder.reverse();
        while (builder.length()>1 && builder.charAt(0)=='0'){
            builder.deleteCharAt(0);

        }
        if(builder.length()==0){
            return "0";
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits kdigits = new RemoveKdigits();
        System.out.println(kdigits.removeKdigits("10001",1));
    }
}
