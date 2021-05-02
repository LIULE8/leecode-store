// 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
//
// 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
//
//
//
// 示例 1:
//
// 输入: num = "69"
// 输出: true
//
//
// 示例 2:
//
// 输入: num = "88"
// 输出: true
//
// 示例 3:
//
// 输入: num = "962"
// 输出: false
//
// 示例 4：
//
// 输入：num = "1"
// 输出：true
//
// Related Topics 哈希表 数学
// 246. 中心对称数

package com.leo.algorithm.easy.math;

public class StrobogrammaticNumber {
  public static void main(String[] args) {
    new Solution().isStrobogrammatic("69");
  }

  static class Solution {
    public boolean isStrobogrammatic(String num) {
      //      return method1(num);
      return method2(num);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 29.49% 的用户
     *
     * @param num
     * @return
     */
    private boolean method2(String num) {
      StringBuilder sb = new StringBuilder();
      for (int i = num.length() - 1; i >= 0; i--) {
        char ch = num.charAt(i);
        if (ch == '0' || ch == '1' || ch == '6' || ch == '8' || ch == '9') {
          if (ch == '6') sb.append('9');
          else if (ch == '9') sb.append('6');
          else sb.append(ch);
        } else return false;
      }
      return sb.toString().equals(num);
    }

    /**
     * NumberFormatException: For input string "6088448809"
     *
     * @param num
     * @return
     */
    private boolean method1(String num) {
      int n = 0;
      int tmp = Integer.parseInt(num);
      while (tmp > 0) {
        int a = tmp % 10;
        if (a == 0 || a == 1 || a == 6 || a == 8 || a == 9) {
          if (a == 6) a = 9;
          else if (a == 9) a = 6;
          n = n * 10 + a;
        } else return false;
        tmp /= 10;
      }
      return n == Integer.parseInt(num);
    }
  }
}
