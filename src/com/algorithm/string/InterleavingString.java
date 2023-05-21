package com.algorithm.string;



/**
 * @author ght
 * @date 2022.05.09 11:11 AM
 * @description  97. 交错字符串
 *
 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 *
 */
public class InterleavingString {

    boolean[][] isVisited;

    /**
     * 双指针+回溯
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        isVisited = new boolean[s1.length()+1][s2.length()+1];
        dfs(s1,0,s2,0,s3,0);
        return isVisited[s1.length()][s2.length()];
    }

    /**
     *
     * @param s1
     * @param s1Index
     * @param s2
     * @param s2Index
     * @param s3
     * @return
     */
    private void dfs(String s1, int s1Index, String s2, int s2Index, String s3,int s3Index) {

        // 能进来的都是数量上刚刚对的上的，不会存在单项越界情况

        if(isVisited[s1Index][s2Index]){
            // 记忆化判断
            return;
        }

        if((s1Index<s1.length() || s2Index<s2.length())){
            if(s1Index<s1.length() && s1.charAt(s1Index)==s3.charAt(s3Index)){
                dfs(s1,s1Index+1,s2,s2Index,s3,s3Index+1);
            }

            if(s2Index<s2.length() && s2.charAt(s2Index)==s3.charAt(s3Index)){
                dfs(s1,s1Index,s2,s2Index+1,s3,s3Index+1);
            }else {
                return;
            }
        }
        // 全都被遍历完了
        isVisited[s1Index][s2Index] = true;
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.print(interleavingString.isInterleave("abcy","defe","adbecfgy") + "\n");
    }
}
