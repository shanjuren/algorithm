package com.algorithm.dynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ght
 * @date 2022.04.27 8:28 PM
 * @description 1654. 到家的最少跳跃次数
 *
 * 有一只跳蚤的家在数轴上的位置x处。请你帮助它从位置0出发，到达它的家。
 *
 * 跳蚤跳跃的规则如下：
 *
 * 它可以 往前 跳恰好 a个位置（即往右跳）。
 * 它可以 往后跳恰好 b个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何forbidden数组中的位置。
 * 跳蚤可以往前跳 超过它的家的位置，但是它 不能跳到负整数的位置。
 *
 * 给你一个整数数组forbidden，其中forbidden[i]是跳蚤不能跳到的位置，同时给你整数a，b和x，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x的可行方案，请你返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * 输出：3
 * 解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
 * 示例 2：
 *
 * 输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * 输出：-1
 * 示例 3：
 *
 * 输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * 输出：2
 * 解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
 *
 */
public class MinimumJumpsToReachHome {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        int[] dp = new int[x+b];
        List<Integer> forbiddenList = Arrays.stream(forbidden).boxed().collect(Collectors.toList());
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            // 遇到障碍直接改为0；没有能跳到这里的
            if(forbiddenList.contains(i)) dp[i]=0;
            int go = (i-a)>=0?dp[i-a]:0;
            int back = (i+b)<dp.length?dp[i+b]:0;
            dp[i] = Math.min(go,back)+1;
        }
        return dp[x-1];
    }

    public static void main(String[] args) {
        MinimumJumpsToReachHome minimumJumpsToReachHome = new MinimumJumpsToReachHome();
        int[] test = new int[]{14,4,18,1,15};
        minimumJumpsToReachHome.minimumJumps(test,3,15,9);
    }

}
