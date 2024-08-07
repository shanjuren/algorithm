package com.algorithm.slidingWindow;

/**
 * @description: 424. 替换后的最长重复字符
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 *
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 *
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 可能存在其他的方法来得到同样的结果。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 仅由大写英文字母组成
 * 0 <= k <= s.length
 *
 * @Author: ght
 * @Date: 2024/7/1 21:52
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {

        if (s.length() <= k) {
            return s.length();
        }


       char[] source = s.toCharArray();
       int[] charMaxCounts = new int[26];
       int tmpMaxCount = 0;
       int tmpMaxLength = 0;

        for (int begin = 0,end = 0; end < s.length(); end++) {

            // 右边界限移动
            charMaxCounts[source[end]-'A']++;
            tmpMaxCount = Math.max(tmpMaxCount,charMaxCounts[source[end]-'A']);

            // 判断左边界是否移动
            if((end-begin)>tmpMaxCount+k){
                // end-begin-tmMaxCount = 剩余元素(需要被替换的元素)
                charMaxCounts[source[begin]-'A']--;
                begin++;
            }
            tmpMaxLength = Math.max(tmpMaxLength,end-begin);
        }
        return tmpMaxLength;
    }



    public static void main(String[] args) {
        CharacterReplacement replacement = new CharacterReplacement();
        System.out.println(replacement.characterReplacement("ABAB",2));
    }

}
