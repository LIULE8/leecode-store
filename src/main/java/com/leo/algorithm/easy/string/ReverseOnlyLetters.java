// 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//
//
//
// 示例 1：
//
// 输入："ab-cd"
// 输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
// 输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
// 输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串
// 917. 仅仅反转字母
package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ReverseOnlyLetters {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("dc-ba", new Solution().reverseOnlyLetters("ab-cd"));
    Printer.printCorrectAnswer("j-Ih-gfE-dCba", new Solution().reverseOnlyLetters("a-bC-dEf-ghIj"));
    Printer.printCorrectAnswer(
        "Qedo1ct-eeLg=ntse-T!", new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    Printer.printCorrectAnswer("-", new Solution().reverseOnlyLetters("-"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 81.01% 的用户
     *
     * <p>内存消耗： 37.1 MB , 在所有 Java 提交中击败了 37.00% 的用户
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
      int l = 0, r = S.length() - 1;
      StringBuilder lsb = new StringBuilder();
      StringBuilder rsb = new StringBuilder();
      while (l <= r) {
        while (l <= r
            && (S.charAt(l) < 'A' || S.charAt(l) > 'Z' && S.charAt(l) < 'a' || S.charAt(l) > 'z')) {
          lsb.append(S.charAt(l++));
        }
        if (l > r) break;
        while (l <= r
            && (S.charAt(r) < 'A' || S.charAt(r) > 'Z' && S.charAt(r) < 'a' || S.charAt(r) > 'z')) {
          rsb.append(S.charAt(r--));
        }
        lsb.append(S.charAt(r--));
        if (l > r) break;
        rsb.append(S.charAt(l++));
      }
      return lsb.toString() + rsb.reverse().toString();
    }
  }
}
