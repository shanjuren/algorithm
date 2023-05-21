package com.algorithm.sort;

/**
 * @author ght
 * @date 2022.04.19 10:32 AM
 * @description 归并排序
 * 分而治之，首先还是要把数组拆分出来
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] test = new int[]{8,4,5,7,1,3,6,2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(test);
    }

    public int[] mergeSort(int[] nums){
        int[] tmp = new int[nums.length];
        splitNums(nums,0,nums.length-1,tmp);
        return nums;
    }

    // 二分法拆分
    private void splitNums(int[] nums, int start, int end, int[] tmp) {

        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        // 左边
        splitNums(nums,start,mid,tmp);
        // 右边
        splitNums(nums,mid+1,end,tmp);
        mergeSort(nums,start,end,mid,tmp);
    }

    /**
     * 两个有序数组合并
     * @param nums
     * @param start
     * @param end
     * @param mid
     * @param tmp
     */
    private void mergeSort(int[] nums, int start, int end, int mid, int[] tmp) {


        // 先两数组合并
        int left = start;
        // 分成两段，后半段不包括中间值
        int right = mid+1;
        int tmpIndex = 0;

        // 左右两边都还没有遍历完
        while (left <= mid && right <= end) {
            if(nums[left]>nums[right]){
                tmp[tmpIndex++] = nums[left++];
            }else {
                tmp[tmpIndex++] = nums[right++];
            }
        }

        while (left<=mid){
            tmp[tmpIndex++] = nums[left++];
        }

        while (right<=end){
            tmp[tmpIndex++] = nums[right++];
        }

        // tmp复制到nums中，每次只需要复制当前段内的数组即可
        int index = 0;
        int head=start;
        while (head<=end){
            nums[head++] = tmp[index++];
        }
    }

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    //合并的方法

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println("-------------------------------------");// 打印arr.length-1次
        int i = left; // 初始化i, 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

}
