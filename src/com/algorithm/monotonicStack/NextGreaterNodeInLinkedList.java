package com.algorithm.monotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ght
 * @date 2022.04.13 6:49 PM
 * @description
 * 1019. 链表中的下一个更大节点
 *
 * 给定一个长度为n的链表head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0。
 * 示例 1：
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 *
 * 示例 2：
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 */
public class NextGreaterNodeInLinkedList {


    public static int[] nextLargerNodes(ListNode head) {

        List<Integer> tmpList = new ArrayList<>();
        getNums(head,tmpList);

        int[] result = new int[tmpList.size()];
        LinkedList<Integer> test = new LinkedList<>();

        for (int i = 0; i < tmpList.size(); i++) {

            if(test.peekLast()==null){
                test.addLast(i);
                continue;
            }
            while (!test.isEmpty() && tmpList.get(test.peekLast())<tmpList.get(i)){
                result[test.pollLast()] = tmpList.get(i);
            }
            // 当前节点无论怎么说都要被加进去
            test.addLast(i);
        }
        if(!test.isEmpty()){
            for (int i = 0; i < test.size(); i++) {
                result[test.pollLast()] = 0;
            }
        }
        return Arrays.stream(result).toArray();
    }

    private static void getNums(ListNode head, List<Integer> result) {
        if(head==null) return;
        result.add(head.val);
        getNums(head.next,result);
    }

    public static void main(String[] args) {
        // 2,7,4,3,5
        // [1,7,5,1,9,2,5,1]
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(7);
        n1.next.next = new ListNode(5);
        n1.next.next.next = new ListNode(1);
        n1.next.next.next.next = new ListNode(9);
        n1.next.next.next.next.next = new ListNode(2);
        n1.next.next.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next.next.next = new ListNode(1);
        int[] test = nextLargerNodes(n1);
        System.out.print(test);

    }

}
