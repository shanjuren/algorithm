package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.11 10:13 PM
 * @description
 * 剑指 Offer 45. 把数组排成最小的数
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class SortString {

    public static String minNumber(int[] nums) {

        String test = new String();
        int[] result = quickSort(nums,0,nums.length-1);
        for (int i = 0; i < result.length; i++) {
            test+=new Integer(result[i]).toString();
        }
        return test;
    }

    public static  int[] quickSort(int[] nums,int start,int end){
        if(start>=end) return nums;
        int head=start,tail=end;
        int tmp = nums[end];
        boolean isHead = true;

        while (head!=tail){
            if(isHead){
                // 左边开始遍历
                if(compare(tmp,nums[head])<0){
                    nums[tail] = nums[head];
                    isHead = false;
                }else {
                    head++;
                }
            }else {
                // 左边开始遍历
                if(compare(tmp,nums[tail])>0){
                    nums[head] = nums[tail];
                    isHead = true;
                }else {
                    tail--;
                }
            }
        }
        nums[head] = tmp;
        quickSort(nums,start,head-1);
        quickSort(nums,tail+1,end);
        return nums;
    }

    private static int compare(int own, int other) {
        String one = new Integer(own).toString();
        String two = new Integer(other).toString();
       if((one+two).compareTo(two+one)>0){
           return 1;
       }else {
           return -1;
       }
    }


    public static void main(String[] args) {
        int[] test = new int[]{824,938,1399,5607,6973,5703,9609,4398,8247};
        System.out.print(minNumber(test)+"\n");
    }


}
