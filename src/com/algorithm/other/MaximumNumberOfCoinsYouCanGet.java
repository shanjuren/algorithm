package com.algorithm.other;

/**
 * @author ght
 * @date 2022.04.11 3:34 PM
 * @description
 * 1561. 你可以获得的最大硬币数目
 *
 * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
 *
 * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 * Alice 将会取走硬币数量最多的那一堆。
 * 你将会取走硬币数量第二多的那一堆。
 * Bob 将会取走最后一堆。
 * 重复这个过程，直到没有更多硬币。
 * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
 *
 * 返回你可以获得的最大硬币数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：piles = [2,4,1,2,7,8]
 * 输出：9
 * 解释：选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 7 枚硬币的那堆，Bob 取走最后一堆。
 * 选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 2 枚硬币的那堆，Bob 取走最后一堆。
 * 你可以获得的最大硬币数目：7 + 2 = 9.
 * 考虑另外一种情况，如果选出的是 (1, 2, 8) 和 (2, 4, 7) ，你就只能得到 2 + 4 = 6 枚硬币，这不是最优解。
 * 示例 2：
 *
 * 输入：piles = [2,4,5]
 * 输出：4
 * 示例 3：
 *
 * 输入：piles = [9,8,7,6,5,1,2,3,4]
 * 输出：18
 */
public class MaximumNumberOfCoinsYouCanGet {

    public static int maxCoins(int[] piles) {
        int maxNum=0;
        int maxGetTimes=piles.length/3;

        piles = sort(piles,0,piles.length-1);
        for (int i = 0; i < (piles.length-maxGetTimes); i+=2) {
            maxNum+=piles[i+1];

        }
         return maxNum;
    }

    public static int[] sort(int[] piles,int left,int right){

        if(left>=right) return piles;

        int tmp = piles[right];
        int head = left;
        int tail = right;
        boolean isLeft = true;
        while (head!=tail){
            if(isLeft){
                if(piles[head]<tmp){
                    isLeft=false;
                    piles[tail]=piles[head];
                }else {
                    head++;
                }
            }else {
                if(piles[tail]>tmp){
                    isLeft=true;
                    piles[head]=piles[tail];
                }else {
                    tail--;
                }
            }
        }
        piles[head] = tmp;
        sort(piles,left,head-1);
        sort(piles,tail+1,right);
        return piles;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,4,1,2,7,8};
        System.out.print(maxCoins(test));
    }

}
