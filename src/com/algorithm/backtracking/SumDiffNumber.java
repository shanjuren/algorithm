package com.algorithm.backtracking;

/**
 * @description: 357. 统计各位数字都不同的数字个数
 * @Author: ght
 * @Date: 2024/6/29 14:41
 */
public class SumDiffNumber {

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }
        return visit(0,  new boolean[10],Math.min(10, n));
    }

    /**
     *  高位->低位 + 剪枝
     * @param idx
     * @param used
     * @param n
     * @return
     */
    private int visit(int idx, boolean[] used, int n) {

        int count = 0;
        if (idx != n) {
            for (int i = 0; i < 10; i++) {
                // 剪枝：多位数时，第一个数字不能为0
                if (i == 0 && n > 1 && idx == 1) {
                    // 01,02,03,04,05,06,07,08,09
                    continue;
                }
                // 剪枝：不能使用用过的数字
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                // 这里是每一个数字都会遍历到，只考虑到当前数字是否符合规范不考虑其他任何元素
                count += visit(idx + 1, used, n) + 1;
                used[i] = false;
            }
        }
        return count;
    }

//    /**
//     * 公式法
//     * @param n
//     * @return
//     */
//    public int countNumbersWithUniqueDigits(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n == 1) {
//            return 10;
//        }
//        int res = 10, cur = 9;
//        for (int i = 0; i < n - 1; i++) {
//            cur *= 9 - i;
//            res += cur;
//        }
//        return res;
//    }


    public static void main(String[] args) {
        SumDiffNumber sumDiffNumber = new SumDiffNumber();
        System.out.println("\n" + sumDiffNumber.countNumbersWithUniqueDigits(3));
    }
}
