package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class Solution7 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        while (p != null || !s1.empty()) {
            if (p != null) {
                s1.push(p);
                s2.push(p);
                p = p.right;
            } else {
                p = s1.pop();
                p = p.left;
            }
        }
        while (!s2.empty()) {
            result.add(s2.pop().val);
        }
        return result;
    }
}
