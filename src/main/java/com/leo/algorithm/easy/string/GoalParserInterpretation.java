// 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解
// 析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字
// 符串。
//
// 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
//
//
//
// 示例 1：
//
// 输入：command = "G()(al)"
// 输出："Goal"
// 解释：Goal 解析器解释命令的步骤如下所示：
// G -> G
// () -> o
// (al) -> al
// 最后连接得到的结果是 "Goal"
//
//
// 示例 2：
//
// 输入：command = "G()()()()(al)"
// 输出："Gooooal"
//
//
// 示例 3：
//
// 输入：command = "(al)G(al)()()G"
// 输出："alGalooG"
//
//
//
//
// 提示：
//
//
// 1 <= command.length <= 100
// command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
//
// Related Topics 字符串
// 1678. 设计 Goal 解析器

package com.leo.algorithm.easy.string;

import java.util.Stack;

public class GoalParserInterpretation {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public String interpret(String command) {
      //      return method1(command);
      return method2(command);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 70.92% 的用户
     *
     * <p>内存消耗： 36.8 MB , 在所有 Java 提交中击败了 41.40% 的用户
     *
     * @param command
     * @return
     */
    private String method2(String command) {
      StringBuilder sb = new StringBuilder();
      int count =0;
      for (char ch : command.toCharArray()) {
        if (ch == 'G') sb.append(ch);
        else if (ch == '(' || ch == 'a' || ch == 'l') count++;
        else if (ch == ')') {
          sb.append(count == 1 ? "o" : "al");
          count=0;
        }
      }
      return sb.toString();
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 14.86% 的用户
     *
     * <p>内存消耗： 36.6 MB , 在所有 Java 提交中击败了 67.87% 的用户
     *
     * @param command
     * @return
     */
    private String method1(String command) {
      StringBuilder sb = new StringBuilder();
      Stack<Character> stack = new Stack<>();
      for (char ch : command.toCharArray()) {
        if (ch == 'G') sb.append(ch);
        else if (ch == '(' || ch == 'a' || ch == 'l') stack.add(ch);
        else if (ch == ')') {
          if (!stack.isEmpty()) {
            Character c = stack.pop();
            if (c == '(') {
              sb.append("o");
            } else {
              stack.pop();
              stack.pop();
              sb.append("al");
            }
          }
        }
      }
      return sb.toString();
    }
  }
}
