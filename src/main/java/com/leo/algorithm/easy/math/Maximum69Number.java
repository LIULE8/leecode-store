// 给你一个仅由数字 6 和 9 组成的正整数 num。
//
// 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//
// 请返回你可以得到的最大数字。
//
//
//
// 示例 1：
//
// 输入：num = 9669
// 输出：9969
// 解释：
// 改变第一位数字可以得到 6669 。
// 改变第二位数字可以得到 9969 。
// 改变第三位数字可以得到 9699 。
// 改变第四位数字可以得到 9666 。
// 其中最大的数字是 9969 。
//
//
// 示例 2：
//
// 输入：num = 9996
// 输出：9999
// 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
//
// 示例 3：
//
// 输入：num = 9999
// 输出：9999
// 解释：无需改变就已经是最大的数字了。
//
//
//
// 提示：
//
//
// 1 <= num <= 10^4
// num 每一位上的数字都是 6 或者 9 。
//
// Related Topics 数学
// 1323. 6 和 9 组成的最大数字

package com.leo.algorithm.easy.math;

public class Maximum69Number {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 72.42% 的用户
     *
     * <p>内存消耗： 35.3 MB , 在所有 Java 提交中击败了 71.01% 的用户
     *
     * @param num
     * @return
     */
    public int maximum69Number(int num) {
      StringBuilder sb = new StringBuilder();
      String s = String.valueOf(num);
      int k = 0;
      while (k < s.length() && s.charAt(k) == '9') k++;
      return k >= s.length()
          ? num
          : Integer.parseInt(sb.append(s, 0, k).append(9).append(s, k + 1, s.length()).toString());
    }
  }
}
