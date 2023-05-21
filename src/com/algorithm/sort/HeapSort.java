package com.algorithm.sort;

/**
 * @Author: haitao.gao
 * @Description: 堆排序
 * 完全二叉树特性 最下面一层叶子节点数量是上层所有节点之和
 *
 * @Date: 2020/9/19 16:57
 * @Version: 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] record = new int[]{8,4,5,7,1,3,6,2};
        heapSort(record);
        System.out.print(record);

    }

    public static void headSort1(int[] nums){

        // 先构建堆结构，最上面一定是最大或者最小值
        int n = nums.length;
        for (int i = (n-1)/2; i > 0 ; i--) {
            adjustmentHead(nums,i,n);
        }

        // 开始从后往前开始遍历
        for (int i = n-1; i >=0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            adjustmentHead(nums,0,i);
        }
    }


    /**
     * 调整堆结构，把最大或者最小推到最上面
     * @param nums
     * @param parents 父节点位置，根据 2*n+1=left 2*n+2=right 计算得出
     * @param maxRight
     */
    private static void adjustmentHead(int[] nums, int parents, int maxRight) {

        // 这个玩意只是腾地方，只要不是最大或者最小都可以不用care
        int tmp = nums[parents];

        int leftSon = 2 * parents + 1;

        while (leftSon < maxRight) {
            // 二叉树最多两个子节点
            int rightSon = leftSon + 1;
            if (rightSon < maxRight && nums[leftSon] < nums[rightSon]) {
                // 空间偷懒，用这个当做下一个循环的parents;
                leftSon++;
            }

            if (tmp >= nums[leftSon]) {
                // 如果父亲节点本身已经大于子节点，下面就不用调换了，直接找到最大或者最小值
                break;
            }

            nums[parents] = nums[leftSon];

            // 遍历子节点还要没有比前面大的
            parents = leftSon;
            leftSon = 2 * parents + 1;
        }
        // 调换位置
        nums[parents] = tmp;
    }




    public static void heapSort(int[] nums){

        int n = nums.length;

        // 确保叶子节点都是比当前小或者比当前大
        for (int i = (n-1)/2; i >0; i--) {
            adjustHead(nums,i,n-1);
        }

        // 开始调换顺序
        for (int i = n-1; i >0; i--) {
            int tmp  = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            adjustHead(nums,0,i);
        }
    }

    /**
     * 调整堆
     * @param nums
     * @param parents  父亲节点
     * @param maxRight 最右边界
     */
    private static void adjustHead(int[] nums, int parents, int maxRight) {

        int tmp = nums[parents];
        int leftChildren = parents*2+1;

        while (leftChildren<maxRight){

            int rightChildren = parents*2+2;
            // 找到两个子节点中哪个最大
            if(rightChildren<maxRight && nums[leftChildren]<nums[rightChildren]){
                leftChildren++;
            }
            if(tmp<nums[leftChildren]){
                nums[parents] = nums[leftChildren];
            }

           parents = leftChildren;
            leftChildren = parents*2+1;
        }
        nums[parents] = tmp;
    }

}
