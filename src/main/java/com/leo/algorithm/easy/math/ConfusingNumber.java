// 给定一个数字 N，当它满足以下条件的时候返回 true：
//
// 原数字旋转 180° 以后可以得到新的数字。
//
// 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
//
// 2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
//
// 易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
//
//
//
// 示例 1：
//
//
//
// 输入：6
// 输出：true
// 解释：
// 把 6 旋转 180° 以后得到 9，9 是有效数字且 9!=6 。
//
//
// 示例 2：
//
//
//
// 输入：89
// 输出：true
// 解释:
// 把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89 。
//
//
// 示例 3：
//
//
//
// 输入：11
// 输出：false
// 解释：
// 把 11 旋转 180° 以后得到 11，11 是有效数字但是值保持不变，所以 11 不是易混淆数字。
//
//
// 示例 4：
//
//
//
// 输入：25
// 输出：false
// 解释：
// 把 25 旋转 180° 以后得到的不是数字。
//
//
//
//
// 提示：
//
//
// 0 <= N <= 10^9
// 可以忽略掉旋转后得到的前导零，例如，如果我们旋转后得到 0008 那么该数字就是 8 。
//
// Related Topics 数学
// 1056. 易混淆数

package com.leo.algorithm.easy.math;

public class ConfusingNumber {
  public static void main(String[] args) {
    boolean b = new Solution().confusingNumber(160);
    System.out.println(b);
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.2 MB , 在所有 Java 提交中击败了 73.81% 的用户
     *
     * @param N
     * @return
     */
    public boolean confusingNumber(int N) {
      int num = 0;
      int tmp = N;
      while (tmp > 0) {
        int a = tmp % 10;
        if (a == 0 || a == 1 || a == 9 || a == 8 || a == 6) {
          if (a == 9) a = 6;
          else if (a == 6) a = 9;
          num = num * 10 + a;
        } else return false;
        tmp /= 10;
      }
      return num != N;
    }
  }
}
