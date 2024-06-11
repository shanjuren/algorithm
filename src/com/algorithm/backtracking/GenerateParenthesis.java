package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * @Author: ght
 * @Date: 2024/6/8 14:36
 */
public class GenerateParenthesis {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        char[] tmp = new char[2 * n];
        dfs(tmp, n, n, 0);
        return result;
    }

    private void dfs(char[] tmp, int leftSum, int rightSum, int curIndex) {
        if (leftSum > rightSum || leftSum < 0 || rightSum < 0) {
            return;
        }

        if (leftSum == rightSum && leftSum == 0) {
            result.add(new String(tmp));
            return;
        }

        //先左后右
        tmp[curIndex] = '(';
        dfs(tmp, leftSum - 1, rightSum, curIndex + 1);
        tmp[curIndex] = ')';
        dfs(tmp, leftSum, rightSum - 1, curIndex + 1);
    }

    public static void main(String[] args) {
        GenerateParenthesis parenthesis = new GenerateParenthesis();
        List<String> result = parenthesis.generateParenthesis(3);
        System.out.println(result);
    }

}
