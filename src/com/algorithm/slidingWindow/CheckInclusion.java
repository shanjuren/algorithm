package com.algorithm.slidingWindow;

import java.util.Arrays;

/**
 * @description: 567. 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/description/
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @Author: ght
 * @Date: 2024/7/7 11:48
 */
public class CheckInclusion {


    public boolean checkInclusion(String s1, String s2) {
        int sourceLength = s1.length();
        int targetLength = s2.length();

        if(targetLength<sourceLength){
            return false;
        }

        int[] sources = new int[26];
        int[] targets = new int[26];
        // 26字母出现的格式
        for (int i = 0; i < sourceLength; i++) {
            ++sources[s1.charAt(i)-'a'];
            ++targets[s2.charAt(i)-'a'];
        }
        if(Arrays.equals(sources,targets)){
            return true;
        }

        // 滑动窗口，上面已经预设了窗口Source，下面开始匹配Target
        for (int i = sourceLength; i < targetLength; i++) {
            ++targets[s2.charAt(i)-'a'];
            --targets[s2.charAt(i-sourceLength)-'a'];

            if(Arrays.equals(sources,targets)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion inclusion = new CheckInclusion();
        System.out.println(inclusion.checkInclusion("ab","eidbaooo"));
    }
}
