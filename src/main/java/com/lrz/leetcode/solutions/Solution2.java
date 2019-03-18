package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小深度
 */
public class Solution2 {
    //递归
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = run(root.left);
        int r = run(root.right);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        return 1 + Math.min(l, r);
    }

    //层次遍历
    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            for (int i = 0;i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
