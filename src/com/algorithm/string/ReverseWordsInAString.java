package com.algorithm.string;

/**
 * @author ght
 * @date 2022.05.09 4:39 PM
 * @description 151. 颠倒字符串中的单词
 */
public class ReverseWordsInAString {

    char tmpChar;

//    public String reverseWords(String s) {
//    if(s==null || (s=s.trim()).isEmpty()) return "";
//
//        // 先整体反转
//        StringBuilder builder = new StringBuilder(s).reverse();
//
//        // 逐个单词修复
//        int start = 0,end=0;
//
//        while (end<s.length()){
//
//            // 遇到空格开始交换
//            if(builder.charAt(end)==' '){
//                // 清理空格
//
//                reverseWords(builder,start,end-1);
//                start = end;
//            }
//            end++;
//        }
//        reverseWords(builder,start,end-1);
//
//       return builder.toString();
//    }

    public String reverseWords(String s) {
        if(s==null || (s=s.trim()).isEmpty()) return "";
        int i,j,start,end;
        //首先翻转trim()后的一大长条字符串，之后再翻转每个单词(String内定义的char[]用final修饰，不可再变)
        StringBuilder sentence=new StringBuilder(s).reverse();
        //用来记录一个单词的前后两个空格
        start=end=0;
        for(i=0;i<sentence.length();i++){
            //如果碰到了一个空格，说明这个空格前到之前的一个空格已经有一个单词了，现在要翻转这个单词了
            if(sentence.charAt(i)==' '){
                //单词之间只能有一个空格，删除多余空格
                j=i+1;
                while(sentence.charAt(j)==' '){
                    j++;
                }
                //delete方法前 包括，后 不包括
                // 相同就不会删减
                sentence.delete(i+1,j);
                //翻转单个单词
                end=i-1;
                revSingleWord(sentence,start,end);
                //重新确定下一个单词的起始位置
                start=i+1;
            }
        }
        //由于最后一个单词末尾没有空格，所以这里多处理一下
        revSingleWord(sentence,start,i-1);
        return sentence.toString();
    }

    public void revSingleWord(StringBuilder sentence,int start,int end){
        while(start<end){
            char temp=sentence.charAt(start);
            sentence.setCharAt(start++,sentence.charAt(end));
            sentence.setCharAt(end--,temp);
        }
    }

    /**
     * 翻转单词
     * @param builder
     * @param start
     * @param end
     */
    private void reverseWords(StringBuilder builder, int start, int end) {

        if(start>builder.length() || end<0) return;
        if(builder.charAt(start)==' ') start++;
        if(builder.charAt(end)==' ') end--;
        while (start<end){
            tmpChar = builder.charAt(start);
            builder.setCharAt(start,builder.charAt(end));
            builder.setCharAt(end,tmpChar);
            start++;
            end--;
        }
    }




    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.print(reverseWordsInAString.reverseWords("  hello world  "));
    }
}
