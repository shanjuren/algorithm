package com.algorithm.string;

/**
 * @author ght
 * @date 2022.04.27 4:05 PM
 * @description 1328. 破坏回文串
 */
public class BreakAPalindrome {

//    public String breakPalindrome(String palindrome) {
//        int maxHalf = palindrome.length()/2;
//        maxHalf+= (palindrome.length()%2);
//        boolean hasReplace = false;
//
//        for (int i = 0; i < maxHalf; i++) {
//            if(palindrome.charAt(i)>'a'){
//                // 替换
//                hasReplace = true;
//                palindrome = palindrome.substring(0,i)+'a'+palindrome.substring(i+1);
//                break;
//            }
//        }
//        return hasReplace?palindrome:"";
//    }

    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] array = palindrome.toCharArray();
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            char c = array[i];
            if (c != 'a') {
                array[i] = 'a';
                return new String(array);
            }
        }
        array[n - 1] = 'b';
        return new String(array);
    }


    public static void main(String[] args) {
        BreakAPalindrome breakAPalindrome = new BreakAPalindrome();
        String test = new String("aa");
    }

}
