package com.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: haitao.gao
 * @Description: 冒泡排序
 * @Date: 2020/9/19 15:19
 * @Version: 1.0
 */
public class BubbleSort {

    public static void sort(List<Integer> recordList){
        for (int i = 0; i < recordList.size(); i++) {
            for (int j = i; j < recordList.size(); j++) {
                if(recordList.get(i)<recordList.get(j)){
                    Integer tmp = recordList.get(i);
                    recordList.set(i,recordList.get(j));
                    recordList.set(j,tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> record = Arrays.asList(2,7,3,11,1,8,6,5);
        BubbleSort.sort(record);
        System.out.print(record.toString());
    }

}
