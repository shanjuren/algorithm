package com.algorithm.slidingWindow;

/**
 * @author ght
 * @date 2022.04.22 5:11 PM
 * @description
 * 1567. 乘积为正数的最长子数组长度
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {

    public static int getMaxLen(int[] nums) {
        int n = nums.length;
        int maxLength = 0;


        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[j]==0 || nums[i]==0) continue;
                int tmp = 1;
                for (int k = i; k <= j; k++) {
                    tmp*=nums[k];
                }
                if(tmp>=0 && maxLength<(j-i+1)){
                    maxLength = j-i+1;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,1,-2,-3,-4};
        System.out.print(getMaxLen(test)+"\n");
    }
}
