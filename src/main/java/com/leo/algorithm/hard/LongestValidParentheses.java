// 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
// 输出: 2
// 解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
// 输出: 4
// 解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划
// 👍 793 👎 0

//32. 最长有效括号

package com.leo.algorithm.hard;

import com.leo.algorithm.utils.Printer;

import java.util.Stack;

public class LongestValidParentheses {
  public static void main(String[] args) {
    Printer.printCorrectInt(2, new Solution().longestValidParentheses("(()"));
    Printer.printCorrectInt(4, new Solution().longestValidParentheses(")()())"));
    Printer.printCorrectInt(6, new Solution().longestValidParentheses("()(())"));
    Printer.printCorrectInt(2, new Solution().longestValidParentheses("()(()"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 52.88% 的用户
     *
     * <p>内存消耗： 40 MB , 在所有 Java 提交中击败了 9.52% 的用户
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
      int max = 0;
      Stack<Integer> stack = new Stack<>();
      stack.push(-1);
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
          stack.push(i);
        } else {
          stack.pop();
          if (stack.isEmpty()) {
            stack.push(i);
          } else {
            max = Math.max(max, i - stack.peek());
          }
        }
      }
      return max;
    }
  }
}
