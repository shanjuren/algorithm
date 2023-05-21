package com.algorithm.string;

/**
 * @author ght
 * @date 2022.05.19 3:59 PM
 * @description 7. 整数反转
 */
public class ReverseInteger {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.print(reverseInteger.reverse(1563847412));
    }

}
