package com.algorithm.other;

/**
 * @author ght
 * @date 2022.04.13 6:24 PM
 * @description
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {

        String test = new String();
        int[] result = quickSort(nums,0,nums.length-1);
        for (int i = result.length-1; i >=0; i--) {
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
        System.out.print(largestNumber(new int[0]));
    }

}
