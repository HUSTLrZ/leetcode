package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution5 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeSort(sortList(head), sortList(midNext));
    }

    private ListNode getMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private ListNode mergeSort(ListNode node1, ListNode node2) {
        ListNode preHead = new ListNode(0);
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        ListNode cur = preHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return preHead.next;
    }
}
