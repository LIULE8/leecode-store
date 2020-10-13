// 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//
// 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//
// 返回可以通过分割得到的平衡字符串的最大数量。
//
//
//
// 示例 1：
//
// 输入：s = "RLRRLLRLRL"
// 输出：4
// 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//
//
// 示例 2：
//
// 输入：s = "RLLLLRRRLR"
// 输出：3
// 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//
//
// 示例 3：
//
// 输入：s = "LLLLRRRR"
// 输出：1
// 解释：s 只能保持原样 "LLLLRRRR".
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] = 'L' 或 'R'
// 分割得到的每个字符串都必须是平衡字符串。
//
// Related Topics 贪心算法 字符串
// 1221. 分割平衡字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class SplitAStringInBalancedStrings {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(4, new Solution().balancedStringSplit("RLRRLLRLRL"));
    Printer.printCorrectAnswer(3, new Solution().balancedStringSplit("RLLLLRRRLR"));
    Printer.printCorrectAnswer(1, new Solution().balancedStringSplit("LLLLRRRR"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.7 MB , 在所有 Java 提交中击败了 33.46% 的用户
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
      int count = 0, sum = 0;
      for (char ch : s.toCharArray()) {
        if (ch == 'R') count++;
        else if (ch == 'L') count--;
        if (count == 0) sum++;
      }
      return sum;
    }
  }
}
