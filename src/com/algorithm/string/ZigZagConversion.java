package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ght
 * @date 2022.05.19 3:41 PM
 * @description  6. Z 字形变换
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            resultList.add(new String());
        }
        char[] sChars = s.toCharArray();

        boolean isPositive = true;
        int cur = 0;
        for (int i = 0; i < sChars.length; i++) {
            resultList.set(cur,resultList.get(cur)+new Character(sChars[i]));

            if(numRows>1){
                if( isPositive){
                    isPositive = (cur==(numRows-1)?false:true);
                }else {
                    isPositive = (cur==0?true:false);
                }

                if(isPositive){
                    cur++;
                }else {
                    cur--;
                }
            }

        }
       String result = new String();
        for (int i = 0; i < resultList.size(); i++) {
            result+=resultList.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.print(zigZagConversion.convert("AB",1));

    }
}
