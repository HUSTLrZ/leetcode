package com.lrz.leetcode.solutions;

import java.util.Stack;

/**
 * 计算后缀表达式
 */
public class Solution3 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (isNumeric(str)) {
                stack.push(str);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if (str.equals("+")) {
                    stack.push(String.valueOf(a + b));
                }
                if (str.equals("-")) {
                    stack.push(String.valueOf(b - a));
                }
                if (str.equals("*")) {
                    stack.push(String.valueOf(a * b));
                }
                if (str.equals("/")) {
                    stack.push(String.valueOf(b / a));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isNumeric(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return false;
        }
        return true;
    }
}
