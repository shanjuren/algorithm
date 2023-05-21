package com.algorithm.manacher;

import java.util.*;

/**
 * @author ght
 * @date 2022.05.05 4:47 PM
 * @description 131. 分割回文串
 */
public class PalindromePartitioning {

//    public List<List<String>> partition(String s) {
//        int len = s.length();
//        // 结果
//        List<List<String>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//
//        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
//        // 注意：只使用 stack 相关的接口
//        Deque<String> stack = new ArrayDeque<>();
//        char[] charArray = s.toCharArray();
//        dfs(charArray, 0, len, stack, res);
//        return res;
//    }
//
//    /**
//     *  核心思想还是深度遍历加记忆化剪枝，单个字符都是回文字，所以倒序遍历，很像单个背包问题，求剩余空间可行性方案
//     * @param charArray
//     * @param index     起始字符的索引
//     * @param len       字符串 s 的长度，可以设置为全局变量
//     * @param path      记录从根结点到叶子结点的路径
//     * @param res       记录所有的结果
//     */
//    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
//        // 全部遍历完
//        if (index == len) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = index; i < len; i++) {
//            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
//            if (!checkPalindrome(charArray, index, i)) {
//                continue;
//            }
//            path.addLast(new String(charArray, index, i + 1 - index));
//            dfs(charArray, i + 1, len, path, res);
//            path.removeLast();
//        }
//    }
//
//    /**
//     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
//     *
//     * @param charArray
//     * @param left      子串的左边界，可以取到
//     * @param right     子串的右边界，可以取到
//     * @return
//     */
//    private boolean checkPalindrome(char[] charArray, int left, int right) {
//        while (left < right) {
//            if (charArray[left] != charArray[right]) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

    public List<List<String>> partition(String s) {

        int n  = s.length();
        List<List<String>> result = new ArrayList<>();
        char[] tmpCharArray = s.toCharArray();
        Deque<String> stack = new ArrayDeque<>();

        dfs(0,n,result,tmpCharArray,stack);
        return result;
    }

    /**
     *
     * @param index
     * @param maxLength
     * @param result
     * @param tmpCharArray
     * @param path
     */
    private void dfs(int index, int maxLength, List<List<String>> result, char[] tmpCharArray, Deque<String> path) {

        // 剩余空间已经没有了
        if(index>=maxLength){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < maxLength; i++) {
            // 检查index到i之间是否有回文字，这里单个回文字不认为是回文字结构，否则重复计算了
            if(!checkPalindrome(tmpCharArray,index,i)){
                continue;
            }
            path.add(new String(tmpCharArray,index,i+1-index));
            dfs(i+1,maxLength,result,tmpCharArray,path);
            // 回溯的关键，退出最后一个
            path.removeLast();

        }

    }

    /**
     * 这里可以用一个数据动态记忆
     * @param tmpCharArray
     * @param start
     * @param end
     * @return
     */
    private boolean checkPalindrome(char[] tmpCharArray, int start, int end) {

        while (start<end){
            if(tmpCharArray[start]!=tmpCharArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("abaab");

    }

}
