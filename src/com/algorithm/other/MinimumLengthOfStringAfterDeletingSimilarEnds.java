package com.algorithm.other;

/**
 * @author ght
 * @date 2022.04.27 7:45 PM
 * @description 1750. 删除字符串两端相同字符后的最短长度
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public int minimumLength(String s) {
        int n=s.length();
        int left = 0;
        int right = n-1;

        while (left< right){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }

            while (left<right && s.charAt(left)==s.charAt(left+1)){
                left++;
            }

            while (left<right && s.charAt(right)==s.charAt(right-1)){
                right--;
            }
            left++;
            right--;
        }
        return right<left?0:(right-left+1);
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterDeletingSimilarEnds minimumLengthOfStringAfterDeletingSimilarEnds = new MinimumLengthOfStringAfterDeletingSimilarEnds();
        System.out.print(minimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }

}
