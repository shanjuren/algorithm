package com.algorithm.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ght
 * @date 2022.04.06 6:17 PM
 * @description
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {

        int[] dp = new int[s.length()+1];
        int maxLength = s.length();
        Set<String> recordSet = new HashSet<String>(wordDict);
        dp[0] = 1;

        for (int i = 1; i <= maxLength; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]==1 && recordSet.contains(s.substring(j,i))){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()]==1?true:false;
    }



}
