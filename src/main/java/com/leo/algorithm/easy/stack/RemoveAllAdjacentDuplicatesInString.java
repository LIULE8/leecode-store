// 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
//
//
//
// 示例：
//
// 输入："abbaca"
// 输出："ca"
// 解释：
// 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
// 只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
//
//
//
//
// 提示：
//
//
// 1 <= S.length <= 20000
// S 仅由小写英文字母组成。
//
// Related Topics 栈
// 1047. 删除字符串中的所有相邻重复项

package com.leo.algorithm.easy.stack;

import com.leo.algorithm.utils.Printer;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("ca", new Solution().removeDuplicates("abbaca"));
  }

  static class Solution {
    /**
     * 执行用时： 39 ms , 在所有 Java 提交中击败了 27.10% 的用户
     *
     * <p>内存消耗： 39.2 MB , 在所有 Java 提交中击败了 33.39% 的用户
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < S.length(); i++) {
        if (stack.empty() || stack.peek() != S.charAt(i)) {
          stack.add(S.charAt(i));
        } else {
          stack.pop();
        }
      }
      StringBuilder sb = new StringBuilder();
      while (!stack.empty()) {
        sb.append(stack.pop());
      }
      return sb.reverse().toString();
    }
  }
}
