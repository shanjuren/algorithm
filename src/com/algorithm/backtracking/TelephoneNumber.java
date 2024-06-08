package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * @Author: ght
 * @Date: 2024/6/1 15:39
 */
public class TelephoneNumber {

    List<String> result = new ArrayList<>();
    private char[][] telNums = new char[][]{{},{'a','b','c',' '},{'d','e','f',' '},{'g','h','i',' '},{'j','k','l',' '},{'m','n','o',' '},{'p','q','r','s'},{'t','u','v',' '},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        char[] digitsArray = digits.toCharArray();
        char[] tmp = new char[digits.length()];
        dfs(digitsArray,tmp,0);
        return result;
    }


    private void dfs(char[] digitsArray, char[] tmp, int index) {
        if(index>tmp.length){
            return;
        }
        if(index == tmp.length){
            result.add(new String(tmp));
            return;
        }

        char[]  num = telNums[Character.digit(digitsArray[index], 10)-1];
        for (int i = 0; i < num.length; i++) {
            if(num[i] == ' '){
                continue;
            }
            tmp[index] = num[i];
            dfs(digitsArray,tmp,index+1);
        }

    }

    public static void main(String[] args) {
        TelephoneNumber number = new TelephoneNumber();
        System.out.println(number.letterCombinations("23"));
    }
}
