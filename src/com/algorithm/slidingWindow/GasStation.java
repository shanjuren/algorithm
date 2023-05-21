package com.algorithm.slidingWindow;

/**
 * @author ght
 * @date 2022.04.11 10:17 AM
 * @description
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * 示例 1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * 示例 2:
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n=gas.length;

        while (i<n){
            int sumGas=0,sumCost=0;
            int currentIndex=0;
            // 只有当前current表示从当前带你触发到下一个站的数量，只有等于全部站数才表示全部遍历完成
            while (currentIndex<n){
                // 通过求余表示环
                int j = (currentIndex+i)%n;
                sumGas +=gas[j];
                sumCost+=cost[j];
                if(sumCost>sumGas){
                    break;
                }
                currentIndex++;
            }
            if(currentIndex==n){
                return i;
            }else {
                // 无需全部遍历，前面能走通可以直接从走通的点继续走下去
                i=i+currentIndex+1;
            }
        }
        return -1;
    }

    public static int canCompleteCircuitV2(int[] gas, int[] cost) {
        // 第一步遍历基础节点，寻找出发点
        int n = gas.length;
        int i = 0;
        // 会超出时间限制
        while(i<n){
            int sumGas=0,sumCost=0;
                    int hasRunStation=0;
            while(hasRunStation<n){
                // 求余代表环
                int tmpIndex = (i+hasRunStation)%n;
                sumGas+=gas[tmpIndex];
                sumCost+=cost[tmpIndex];
                if(sumGas<sumCost){
                    // 没油了，走不下去
                    break;
                }
                hasRunStation++;
                if(hasRunStation==n){
                    return i;
                }else {
                    // 无需重复遍历
                    i = i+hasRunStation+1;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] gas= new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.print(canCompleteCircuitV2(gas,cost));
    }

}
