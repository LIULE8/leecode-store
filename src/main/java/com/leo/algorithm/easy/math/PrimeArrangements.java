// 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
//
//
//
// 示例 1：
//
// 输入：n = 5
// 输出：12
// 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
//
//
// 示例 2：
//
// 输入：n = 100
// 输出：682289015
//
//
//
//
// 提示：
//
//
// 1 <= n <= 100
//
// Related Topics 数学
// 1175. 质数排列

package com.leo.algorithm.easy.math;

public class PrimeArrangements {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.1 MB , 在所有 Java 提交中击败了 74.21% 的用户
     *
     * @param n
     * @return
     */
    public int numPrimeArrangements(int n) {
      int[] zhishu = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
        97
      };
      // 计算质数个数
      int nzhishu = 0;
      for (int c : zhishu) {
        if (n >= c) nzhishu++;
      }
      // 计算非质数的个数
      long ans = 1;
      int nfeizhishu = n - nzhishu;
      ans = countNum(nfeizhishu, ans);
      ans = countNum(nzhishu, ans);
      return (int) ans % 1000000007;
    }

    private long countNum(int num, long ans) {
      for (int i = num; i > 1; i--) {
        if (ans < 1000000007 / i) {
          ans *= i;
        } else {
          ans = ans * i % 1000000007;
        }
      }
      return ans;
    }
  }
}
