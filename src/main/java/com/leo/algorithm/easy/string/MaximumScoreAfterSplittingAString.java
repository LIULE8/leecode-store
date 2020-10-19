// 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
//
//
// 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
//
//
//
// 示例 1：
//
// 输入：s = "011101"
// 输出：5
// 解释：
// 将字符串 s 划分为两个非空子字符串的可行方案有：
// 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
// 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
// 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
// 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
// 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
//
//
// 示例 2：
//
// 输入：s = "00111"
// 输出：5
// 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
//
//
// 示例 3：
//
// 输入：s = "1111"
// 输出：3
//
//
//
//
// 提示：
//
//
// 2 <= s.length <= 500
// 字符串 s 仅由字符 '0' 和 '1' 组成。
//
// Related Topics 字符串
// 1422. 分割字符串的最大得分

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class MaximumScoreAfterSplittingAString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(5, new Solution().maxScore("011101"));
    Printer.printCorrectAnswer(5, new Solution().maxScore("00111"));
    Printer.printCorrectAnswer(3, new Solution().maxScore("1111"));
    Printer.printCorrectAnswer(1, new Solution().maxScore("00"));
    Printer.printCorrectAnswer(1, new Solution().maxScore("00"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.2 MB , 在所有 Java 提交中击败了 99.18% 的用户
     *
     * @param s
     * @return
     */
    public int maxScore(String s) {
      int leftZero = 0, rightOne = 0;
      char[] chars = s.toCharArray();
      for (char c : chars) {
        if (c == '1') rightOne++;
      }
      int max = 0;
      for (int i = 0; i < chars.length - 1; i++) {
        if (chars[i] == '0') {
          leftZero++;
        } else {
          rightOne--;
        }
        max = Math.max(leftZero + rightOne, max);
      }
      return max;
    }
  }
}
