// 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//
//
// 示例 1：
//
//
// 输入：s = "1 + 1"
// 输出：2
//
//
// 示例 2：
//
//
// 输入：s = " 2-1 + 2 "
// 输出：3
//
//
// 示例 3：
//
//
// 输入：s = "(1+(4+5+2)-3)+(6+8)"
// 输出：23
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
//
// 224. 基本计算器
//
// Related Topics 栈 递归 数学 字符串

package com.leo.algorithm.hard.stack;

import com.leo.algorithm.utils.Printer;

import java.util.Stack;

public class BasicCalculator {
  public static void main(String[] args) {
    //    Printer.printCorrectAnswer(2, new Solution().calculate("1 + 1"));
    //    Printer.printCorrectAnswer(3, new Solution().calculate("2-1 + 2 "));
    Printer.printCorrectAnswer(2, new Solution().calculate("3 + (( 2 + 1) - 2 + (1 - 3)) "));
    //    Printer.printCorrectAnswer(-1, new Solution().calculate("-2+ 1"));
    //    Printer.printCorrectAnswer(3, new Solution().calculate("1-(-2)"));
  }

  static class Solution {
    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 65.69% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 48.02% 的用户
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
      // sign 代表正负
      int sign = 1, res = 0;
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (Character.isDigit(ch)) {
          int num = ch - '0';
          while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
            num = num * 10 + s.charAt(++i) - '0';
          res = res + sign * num;
        } else if (ch == '+') {
          sign = 1;
        } else if (ch == '-') {
          sign = -1;
        } else if (ch == '(') {
          stack.push(res);
          res = 0;
          stack.push(sign);
          sign = 1;
        } else if (ch == ')') {
          res = stack.pop() * res + stack.pop();
        }
      }
      return res;
    }
  }
}
