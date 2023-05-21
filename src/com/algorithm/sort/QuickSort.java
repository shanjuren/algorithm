package com.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: haitao.gao
 * @Description: 快速排序
 *
 * @Date: 2020/9/19 15:24
 * @Version: 1.0
 */
public class QuickSort {


    /**
     * 双向冒泡排序，
     * @param recordList
     * @param start
     * @param end
     */
    public static void sort(List<Integer> recordList,Integer start,Integer end){

        if(start == end || start>end) return;
        //取基准数据
        Integer standard = recordList.get(end);
        Boolean isHead = true;
        Integer head = start;
        Integer tail = end;
        while (head != tail){
            if(isHead){
                if(recordList.get(head)<standard){
                    recordList.set(tail,recordList.get(head));
                    isHead = false;
                }else {
                    head++;
                }
            }else {
                if(recordList.get(tail)>standard){
                    recordList.set(head,recordList.get(tail));
                    isHead = true;
                }else {
                    tail--;
                }
            }
        }
        recordList.set(tail,standard);
        //排序前半段
        sort(recordList,start,head-1);
        //排序后半段
        sort(recordList,head+1,end);
    }


    public static List<Integer> quickSort(List<Integer> recordList, Integer start, Integer end) {
        if (start >= end) {
            return recordList;
        }

        int head = start;
        int tail = end;
        int standard = recordList.get(tail);
        boolean isBefore = true;

        while (head != tail) {
            if (isBefore) {
                // 前半段寻找比中间值大的数字
                if (recordList.get(head) > standard) {
                    recordList.set(tail, recordList.get(head));
                    isBefore = false;
                } else {
                    head++;
                }
            } else {
                // 后半段寻找比中间值小的数字
                if (recordList.get(tail) < standard) {
                    recordList.set(head, recordList.get(tail));
                    isBefore = true;
                } else {
                    tail--;
                }
            }

        }
        // 最后负责兜底把standard放到中间
        recordList.set(tail, standard);
        quickSort(recordList, start, tail - 1);
        quickSort(recordList, head + 1, end);
        return recordList;
    }


    public static void main(String[] args) {
        List<Integer> record = Arrays.asList(2,7,3,11,1,8,6,5);
        QuickSort.quickSort(record,0,7);
        System.out.print(record);
    }


}
