package com.algorithm.slidingWindow;

/**
 * @description: 904. 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/description/
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 *
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * 示例 2：
 *
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * 示例 3：
 *
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * 示例 4：
 *
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 *
 *
 * 提示：
 *
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 *
 * @Author: ght
 * @Date: 2024/7/19 22:22
 */
public class TotalFruit {

    // 连续的数额最大
    public int totalFruit(int[] fruits) {

        // 最差情况每颗果树都不一样
        int[] fruitsKinds = new int[fruits.length];
        int kindsSum = 0;
        int tmpMaxLength = 0;

        for (int begin = 0, end = 0; end < fruits.length; end++) {

            // 先处理右边界再处理左边界
           if(fruitsKinds[fruits[end]] == 0 && kindsSum>=2){
               // 需要剔除类型
               // 移动窗口
               while (begin<=end){
                   if(--fruitsKinds[fruits[begin]]<=0){
                       kindsSum--;
                       begin++;
                       break;
                   }
                   begin++;
               }
            }
           if(fruitsKinds[fruits[end]] == 0){
               kindsSum++;
           }
            ++fruitsKinds[fruits[end]];
            tmpMaxLength = Math.max(tmpMaxLength,end-begin+1);
        }
        return tmpMaxLength;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(totalFruit.totalFruit(new int[]{1,2,1}));
    }
}
