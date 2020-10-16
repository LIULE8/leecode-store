// 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
//
//
//
// 示例 1：
//
// 输入：name = "alex", typed = "aaleex"
// 输出：true
// 解释：'alex' 中的 'a' 和 'e' 被长按。
//
//
// 示例 2：
//
// 输入：name = "saeed", typed = "ssaaedd"
// 输出：false
// 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
//
//
// 示例 3：
//
// 输入：name = "leelee", typed = "lleeelee"
// 输出：true
//
//
// 示例 4：
//
// 输入：name = "laiden", typed = "laiden"
// 输出：true
// 解释：长按名字中的字符并不是必要的。
//
//
//
//
// 提示：
//
//
// name.length <= 1000
// typed.length <= 1000
// name 和 typed 的字符都是小写字母。
//
//
//
//
//
// Related Topics 双指针 字符串
// 925. 长按键入

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class LongPressedName {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isLongPressedName("alex", "aaleex"));
    Printer.printCorrectAnswer(false, new Solution().isLongPressedName("saeed", "ssaaedd"));
    Printer.printCorrectAnswer(true, new Solution().isLongPressedName("leelee", "lleeelee"));
    Printer.printCorrectAnswer(true, new Solution().isLongPressedName("laiden", "laiden"));
    Printer.printCorrectAnswer(false, new Solution().isLongPressedName("xnhtq", "xhhttqq"));
    Printer.printCorrectAnswer(
        false, new Solution().isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 87.19% 的用户
     *
     * <p>内存消耗： 36.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
      int i = 0, k = 0;
      for (; i < name.length() && k < typed.length(); i++, k++) {
        char name_char = name.charAt(i);
        char typed_char = typed.charAt(k);
        if (name_char != typed_char) return false;
        int name_count = 0, typed_count = 0;
        while (i + 1 < name.length() && name_char == name.charAt(i + 1)) {
          name_count++;
          i++;
        }
        while (k + 1 < typed.length() && typed_char == typed.charAt(k + 1)) {
          typed_count++;
          k++;
        }
        if (name_count > typed_count) return false;
      }
      if (k >= typed.length() - 1 && i < name.length()) return false;
      return k >= typed.length();
    }
  }
}
