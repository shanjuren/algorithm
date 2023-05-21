package com.algorithm.other;

/**
 * @author ght
 * @date 2022.04.27 12:11 PM
 * @description 2130. 链表最大孪生和
 */



public class MaximumTwinSumOfALinkedList {

    int maxSum = 0;

    public static void main(String[] args) {
        MaximumTwinSumOfALinkedList maximumTwinSumOfALinkedList = new MaximumTwinSumOfALinkedList();
        ListNode root = new ListNode(5,new ListNode(4,new ListNode(2,new ListNode(1))));
        System.out.print(maximumTwinSumOfALinkedList.pairSum(root));
    }

    public int pairSum(ListNode head) {
        getMaxSum(head,head);
        return maxSum;
    }


    public ListNode getMaxSum(ListNode head,ListNode tail){
        if(tail!=null){
            ListNode newHead = getMaxSum(head,tail.next);
            int tmpSum = tail.val + (newHead==null?head.val:newHead.val);
            if(maxSum<tmpSum){
                maxSum = tmpSum;
            }
            return (newHead==null?head.next:newHead.next);
        }
        return null;
    }



     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
