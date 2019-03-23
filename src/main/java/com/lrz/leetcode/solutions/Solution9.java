package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.ListNode;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 *
 * You must do this in-place without altering the nodes' values.
 */
public class Solution9 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode after = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (after != null) {
            ListNode tmp = after.next;
            after.next = pre;
            pre = after;
            after = tmp;
        }

        // 合并两个链表
        ListNode first = head;
        after = pre;
        while(first != null && after != null){
            ListNode ftemp = first.next;
            ListNode aftemp = after.next;
            first.next = after;
            first = ftemp;
            after.next = first;
            after = aftemp;
        }
    }
}
