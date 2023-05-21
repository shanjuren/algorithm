package com.algorithm.KMP;

/**
 * @author ght
 * @date 2022.04.15 3:22 PM
 * @description
 *
 *
 */
public class KMP {

    public static int getIndexOf(String st1,String st2){
        // KMP算法核心是先拆分需要匹配的字符串生成一个next数组，通过next数组来记录当前位置的上一个可重复节点位置，避免重复匹配

        char[] str1s = st1.toCharArray();
        char[] str2s = st2.toCharArray();

        // 简单粗暴点理解next里面装的是st2当前元素在st2之前的元素中是否有重复如果有，结束点在哪里，因为值前缀子串所以index也是子串长度
        int[] next = getNextArray(str2s);
        int i=0;
        int j=0;

        while (i<st1.length()&&j<st2.length()){
            if(str1s[i]==str2s[j]){
                i++;
                j++;
            }else if(next[j] ==-1){
                // 当前还没命中，直接往后推进
                i++;
            }else {
                // 有命中之前的子串
                j= next[j];

            }
        }
        return j==st2.length()?(i-j):-1;

    }

    /**
     * next 数组特性，用来记录str中每个元素节点前重复字符串第一个重复串匹配不到的下一个字符串下标
     * @param str2s
     * @return
     */
    private static int[] getNextArray(char[] str2s) {

        /**
         * next 特性
         * 1、每个元素代表该元素前重复前缀子串的的位置
         * 2、注意是重复前缀子串，不只是子串
         * 3、后一个重复前缀子串长度可以通过前一个重复前缀子串的长度+1得出
         */
        int[] next = new int[str2s.length];
        int n = str2s.length;
        next[0]=-1;
        next[1]=0;
        int i = 2;
        // 代表上一次匹配重复的位置可以到哪个节点
        int ctn = 0;
        for (; i <n; i++) {
            // 如果当前字符匹配则两个指针都往前推移
           if(str2s[ctn]==str2s[i-1]){
               next[i++] = ++ctn;
           }else if(ctn>0){
               // 此处如果之前存在重复字符串可以偷懒不必从头再来，直接从ctn处字符不重复的位置开始继续遍历
               ctn = next[ctn];
           }else {
               // 一直没有重复的，直接无脑++
               next[i++] = 0;
           }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.print(getIndexOf("ABABABABC","ABABC"));
    }


}
