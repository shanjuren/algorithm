package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 816. 模糊坐标
 * @Author: ght
 * @Date: 2024/6/29 13:41
 */
public class AmbiguousCoordinates {

    private List<String> result = new ArrayList<>();

    public List<String> ambiguousCoordinates(String s) {

        s = s.substring(1,s.length()-1);

        for (int i = 0; i < s.length(); i++) {
            List<String> left = visit(s,  0,i);
            List<String> right = visit(s,  i+1,s.length()-1);

            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    String tmpResult = "(" + left.get(j) + ", " + right.get(k) + ")";
                    if (!result.contains(tmpResult)) {
                        result.add(tmpResult);
                    }
                }
            }

        }
        return result;
    }

    private List<String> visit(String string,int start,int end) {
        List<String> tmp = new ArrayList<>();
        if(start<0 || end>=string.length() || start>end){
            return tmp;
        }

        if(start==end){
            tmp.add(String.valueOf(string.charAt(start)));
            return tmp;
        }

        // 不加小数点的
        if(string.charAt(start) != '0'){
            tmp.add(string.substring(start,end+1));
        }

        for (int i = start+1; i <= end; i++) {

            if(i != (start+1) && string.charAt(start)=='0'){
                continue;
            }
            if(string.charAt(end) == '0') {
                continue;
            }

            tmp.add(string.substring(start, i) + "." + string.substring(i,end+1));

        }
        return tmp;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates test = new AmbiguousCoordinates();
        System.out.println(test.ambiguousCoordinates("(00011)"));
    }

}
