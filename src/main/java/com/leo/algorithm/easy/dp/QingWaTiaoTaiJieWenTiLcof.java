// 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1：
//
// 输入：n = 2
// 输出：2
//
//
// 示例 2：
//
// 输入：n = 7
// 输出：21
//
//
// 示例 3：
//
// 输入：n = 0
// 输出：1
//
// 提示：
//
//
// 0 <= n <= 100
//
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
//
//
// Related Topics 记忆化搜索 数学 动态规划
// 剑指 Offer 10- II. 青蛙跳台阶问题

package com.leo.algorithm.easy.dp;

public class QingWaTiaoTaiJieWenTiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.2 MB , 在所有 Java 提交中击败了 49.54% 的用户
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
      int a = 1, b = 1, sum;
      for (int i = 0; i < n; i++) {
        sum = (a + b) % 1000000007;
        b = a;
        a = sum;
      }
      return b;
    }
  }
}
