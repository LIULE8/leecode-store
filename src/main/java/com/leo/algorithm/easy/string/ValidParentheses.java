// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
// 输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
// 输出: true
//
//
// 示例 3:
//
// 输入: "(]"
// 输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
// 输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
// 输出: true
// Related Topics 栈 字符串
// 20. 有效的括号

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isValid("()"));
    Printer.printCorrectAnswer(true, new Solution().isValid("()[]{}"));
    Printer.printCorrectAnswer(false, new Solution().isValid("(]"));
    Printer.printCorrectAnswer(false, new Solution().isValid("([)]"));
    Printer.printCorrectAnswer(true, new Solution().isValid("{[]}"));
    Printer.printCorrectAnswer(false, new Solution().isValid("}"));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 78.06% 的用户
     *
     * <p>内存消耗： 37 MB , 在所有 Java 提交中击败了 35.96% 的用户
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      Map<Character, Character> map = new HashMap<>();
      map.put('(', ')');
      map.put('{', '}');
      map.put('[', ']');
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '{' || ch == '(' || ch == '[') stack.add(ch);
        else if (stack.isEmpty()) return false;
        else if (!map.get(stack.pop()).equals(ch)) return false;
      }
      return stack.isEmpty();
    }
  }
}
