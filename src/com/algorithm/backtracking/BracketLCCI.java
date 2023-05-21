package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.27 4:22 PM
 * @description 面试题 08.09. 括号
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class BracketLCCI {

    // 回溯法，判断括号成立的条件 右括号的数量永远大于等于左括号

    public List<String> generateParenthesis(int n) {


        List<String> result = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        dfs(tmp,result,n,n);

        return result;
    }

    private void dfs(StringBuilder tmp, List<String> result, int left, int right) {

        if(left==0 && right==0) {
            result.add(tmp.toString());
            return;
        }

        if(left<0 || right<0 || right<left){
            return;
        }

        // 先左后右
        tmp.append("(");
        dfs(tmp,result,left-1,right);
        tmp.deleteCharAt(tmp.length()-1);
        tmp.append(")");
        dfs(tmp,result,left,right-1);
        tmp.deleteCharAt(tmp.length()-1);
    }

    public static void main(String[] args) {
       BracketLCCI bracketLCCI = new BracketLCCI();
       bracketLCCI.generateParenthesis(3);
    }

}
