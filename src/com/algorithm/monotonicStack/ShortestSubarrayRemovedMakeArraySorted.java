package com.algorithm.monotonicStack;

/**
 * @author ght
 * @date 2022.06.08 11:40 AM
 * @description 1574. 删除最短的子数组使剩余数组有序
 */
public class ShortestSubarrayRemovedMakeArraySorted {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 1, j = n-1;
        while (i<n && arr[i-1]<=arr[i]) ++i;
        if (i == n) return 0; // arr已经有序
        while (j-1>=0 && arr[j-1]<=arr[j]) --j;
        int l = j, r = n-1;
        int ans = j; // 最坏结果只保留right
        for (int k = 0; k < i; ++k) {
            int target = arr[k];
            l = j; r = n; //搜索right区间[j,n-1]
            while (l<r) {
                int mid = (l+r)>>1;
                if (arr[mid] < target) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            ans = Math.min(ans, r-k-1);
        }
        return ans;
    }


    public static void main(String[] args) {
        ShortestSubarrayRemovedMakeArraySorted shortTest = new ShortestSubarrayRemovedMakeArraySorted();
        int[] test = new int[]{1,2,3,10,0,7,8,9};
        System.out.print(shortTest.findLengthOfShortestSubarray(test)+"\n");
    }

}
