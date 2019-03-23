package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.ListNode;

/**
 * Sort a linked list using insertion sort.
 */
public class Solution6 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curNode = head.next;
        ListNode pNode = new ListNode(0);
        pNode.next = head;
        head.next = null;
        while(curNode != null){
            ListNode compareNode = pNode;
            while(compareNode != null){
                if(compareNode.next == null || compareNode.next.val>= curNode.val){
                    break;
                }
                compareNode = compareNode.next;
            }
            ListNode temp = curNode.next;
            curNode.next = compareNode.next;
            compareNode.next = curNode;
            curNode = temp;
        }
        return pNode.next;
    }
}
