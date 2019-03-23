package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class Solution8 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            if (p != null) {
                s.push(p);
                result.add(p.val);
                p = p.left;
            } else {
                p = s.pop();
                p = p.right;
            }
        }
        return result;
    }
}
