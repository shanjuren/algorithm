package com.algorithm.other;

import java.util.Arrays;

/**
 * @author ght
 * @date 2022.04.26 4:24 PM
 * @description 791. 自定义字符串排序
 *
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 *
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 *
 * 返回 满足这个性质的 s 的任意排列。
 *
 * 示例 1:
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 *
 * 示例 2:
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 *
 */
public class CustomSortString {


    public String customSortString(String order, String s) {
        int[] target = new int[26];
        String result =new String();
        Arrays.fill(target,0);
        for (char c : s.toCharArray()) {
            target[c-'a']+=1;
        }

        for (char c : order.toCharArray()) {
            if(target[c-'a']>0){
                result+=(c);
                target[c-'a'] -=1;
            }
        }

        for (int i = 0; i < target.length; i++) {
            if(result.length()==s.length()) break;
            if(target[i]>0){
                result+=((char)('a'+i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CustomSortString customSortString = new CustomSortString();
        System.out.print(customSortString.customSortString("cba","abcd"));

    }

}
