// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
// 输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// Related Topics 字符串
// 剑指 Offer 05. 替换空格

package com.leo.algorithm.easy.string;

public class TiHuanKongGeLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public String replaceSpace(String s) {
      return method1(s);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 14.84% 的用户
     *
     * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 47.65% 的用户
     *
     * @param s
     * @return
     */
    private String method1(String s) {
      if (s == null || s.length() == 0) return s;
      return s.replaceAll(" ", "%20");
    }
  }
}
