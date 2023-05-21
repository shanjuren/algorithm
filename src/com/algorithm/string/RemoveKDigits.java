package com.algorithm.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ght
 * @date 2022.06.08 9:36 AM
 * @description 402. 移掉 K 位数字
 */
public class RemoveKDigits {

    String result = "null";
    public String removeKdigits(String num, int k) {

        dfs(num,0,k);

        while(result.length()>1 && result.charAt(0)=='0'){
            result = result.substring(1);
        }
        return result;
    }

    private void dfs(String num, int i, int k) {

        if(k==0){
            result = (result=="null"||result.compareTo(num)>0)?num:result;
            return;
        }

        for (int j = 0; j < num.length(); j++) {
            // 删除固定位置的字符
            String tmpNum = removeIndex(num,j);
            dfs(tmpNum,0,k-1);
        }
    }

    private String removeIndex(String num, int j) {
        StringBuilder tmpBuilder = new StringBuilder(num);
        tmpBuilder.deleteCharAt(j);
        if(tmpBuilder.toString().isEmpty()){
            return "0";
        }
        return tmpBuilder.toString();
    }


    /**
     * 单调栈
     * @param num
     */
    public String removeKdigits1(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.print(removeKDigits.removeKdigits("10",1));
    }

}
