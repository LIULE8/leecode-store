// 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
//
// 如果相等，返回 true ；否则，返回 false 。
//
// 注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
// 示例 1：
//
//
// 输入：s = "ab#c", t = "ad#c"
// 输出：true
// 解释：S 和 T 都会变成 “ac”。
//
//
// 示例 2：
//
//
// 输入：s = "ab##", t = "c#d#"
// 输出：true
// 解释：s 和 t 都会变成 “”。
//
//
// 示例 3：
//
//
// 输入：s = "a##c", t = "#a#c"
// 输出：true
// 解释：s 和 t 都会变成 “c”。
//
//
// 示例 4：
//
//
// 输入：s = "a#c", t = "b"
// 输出：false
// 解释：s 会变成 “c”，但 t 仍然是 “b”。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 200
// s 和 t 只含有小写字母以及字符 '#'
//
//
//
//
// 进阶：
//
//
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
//
// 844. 比较含退格的字符串

// Related Topics 栈 双指针 字符串 模拟

package com.leo.algorithm.easy.stack;

import java.util.Stack;

public class BackspaceStringCompare {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 25.46% 的用户
     *
     * <p>内存消耗： 37 MB , 在所有 Java 提交中击败了 5.94% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
      Stack<Character> stack1 = new Stack<>();
      Stack<Character> stack2 = new Stack<>();
      int i = 0;
      while (i < s.length() && i < t.length()) {
        handleStr(s, stack1, i);
        handleStr(t, stack2, i++);
      }
      while (i < s.length()) {
        handleStr(s, stack1, i++);
      }
      while (i < t.length()) {
        handleStr(t, stack2, i++);
      }
      return stack1.toString().equals(stack2.toString());
    }

    private void handleStr(String str, Stack<Character> stack, int index) {
      if (str.charAt(index) != '#') stack.add(str.charAt(index));
      else if (!stack.isEmpty()) stack.pop();
    }
  }
}
