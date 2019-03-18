package com.lrz.leetcode.datatypes;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        ListNode p2 = new ListNode(2);
        ListNode p1 = new ListNode(1);
        ListNode head = new ListNode(0);
        head.next = p1;
        p1.next = p2;

        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode node = new ListNode(currentNode.val);
            ListNode next = currentNode.next;
            currentNode.next = node;
            node.next = next;
            currentNode = next;
        }

        currentNode = head;
        System.out.println(currentNode.val);
    }
}