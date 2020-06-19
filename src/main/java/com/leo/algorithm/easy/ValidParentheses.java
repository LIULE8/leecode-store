package com.leo.algorithm.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * <p>有效字符串需满足：
 *
 * <p>左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 *
 * <p>示例 1:
 *
 * <p>输入: "()" 输出: true 示例 2:
 *
 * <p>输入: "()[]{}" 输出: true 示例 3:
 *
 * <p>输入: "(]" 输出: false 示例 4:
 *
 * <p>输入: "([)]" 输出: false 示例 5:
 *
 * <p>输入: "{[]}" 输出: true
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
  public static void main(String[] args) {
    System.out.println(new Solution().isValid("()") + " , expect: true");
    System.out.println(new Solution().isValid("()[]{}") + " , expect: true");
    System.out.println(new Solution().isValid("(]") + " , expect: false");
    System.out.println(new Solution().isValid("([)]") + " , expect: false");
    System.out.println(new Solution().isValid("{[]}") + " , expect: true");
    System.out.println(new Solution().isValid("{") + " , expect: false");
  }

  static class Solution {
    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 59.88% 的用户
     *
     * <p>内存消耗 : 34.9 MB , 在所有 Java 提交中击败了 13.85% 的用户
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
      Map<String, String> map = new HashMap<>();
      map.put("(", ")");
      map.put("[", "]");
      map.put("{", "}");
      Stack<String> stack = new Stack<>();
      char[] chars = s.toCharArray();
      for (char aChar : chars) {
        String key = String.valueOf(aChar);
        if (map.containsKey(key)) {
          stack.push(key);
        } else {
          if (stack.empty()) {
            return false;
          }
          String pop = stack.pop();
          if (!map.get(pop).equals(key)) {
            return false;
          }
        }
      }
      return stack.empty();
    }
  }
}
