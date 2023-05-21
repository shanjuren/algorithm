package com.algorithm.string;

/**
 * @author ght
 * @date 2022.04.04 8:53 PM
 * @description
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        if(s.length()==0 || s.length()==1) return s;
        if(s.length()==2 && s.charAt(0)==s.charAt(1)){
            return s;
        }else if(s.length()==2 && s.charAt(0)!=s.charAt(1)){
            return s.substring(1);
        }
        String longestPalindromic = new String();

        int maxLength = s.length();
        for (int i = 0; i < maxLength; i++) {

            int tmpLong = findLongest(s,i-1,i+1);
            if(longestPalindromic.length()<tmpLong){
                int halfLength = (tmpLong-1)/2;
                longestPalindromic = s.substring(i-halfLength,i+halfLength+1);
            }
            if((i<s.length()-1) && s.charAt(i)==s.charAt(i+1)){
                tmpLong = findLongest(s,i,i+1);
                if(longestPalindromic.length()<tmpLong){
                    int halfLength = (tmpLong-2)/2;
                    longestPalindromic = s.substring(i-halfLength,i+halfLength+2);
                }
            }
        }
        return longestPalindromic;
    }

    private static int findLongest(String s, int start, int end) {
        int currentLength = end-start-1;
        if(start<0 || end>=s.length()){
            return currentLength;
        }
        if(s.charAt(start)==s.charAt(end)){
            return findLongest(s,start-1,end+1);
        }else {
            return currentLength;
        }
    }

    public static void main(String[] args) {
        System.out.printf(longestPalindrome("ccd")+"\n");
    }
}
