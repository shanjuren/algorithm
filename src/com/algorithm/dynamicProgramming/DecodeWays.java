package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.06 10:35 AM
 * @description
 * 91. 解码方法
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 */
public class DecodeWays {


    public static int numDecodings(String s) {

        int length = s.length();
        int[] result = new int[length+1];
        // 初始化很重要
        result[0]=1;
        for (int i = 1; i <=length; i++) {
            // 这里如果第一个不符合直接取数据初始化默认值
            if(s.charAt(i-1)!='0'){
                result[i]+=result[i-1];
            }
            // 这里判断需要计算n-2的情况
            if(i>1 && s.charAt(i-2)!='0'&& ((s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0'))<=26){
                result[i]+=result[i-2];
            }
        }
        return result[length];
    }





    public static int numDecodingsError(String s) {

        if(s.length()==0) return 0;

        int length = s.length();
        int[] recordNum = new int[s.length()];

        //初始化
        int lastFirst = new Integer(s.substring(0,1));
        recordNum[0] = (lastFirst>=1 && lastFirst<=9)?1:0;
        if(s.length()==1) return recordNum[0];
        int lastSecond = new Integer(s.substring(0,2));
        recordNum[1] = (lastSecond>=10 && lastSecond<=26 )?2:0;
        if(s.length()==2) return recordNum[1];

        for (int i = 2; i < length; i++) {
            // 如果当前位倒数两位在1~26之前再计算
            int currentNum = new Integer(s.substring(i-2,i));
            if(currentNum>=10 && currentNum<=26){
                recordNum[i] = recordNum[i-2]+recordNum[i-1];
            }else {
                recordNum[i] = recordNum[i-1];
            }
        }
        return recordNum[length-1];
    }



    public static void main(String[] args) {
        System.out.print(numDecodings("0"));
    }
}
