package com.leo.algorithm.easy.dp;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

/**
 * 256. 粉刷房子
 *
 * <p>假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * <p>当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
 *
 * <p>例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 *
 * <p>注意：
 *
 * <p>所有花费均为正整数。
 *
 * <p>示例：
 *
 * <p>输入: [[17,2,17],[16,16,5],[14,3,19]] 输出: 10 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *
 * <p>最少花费: 2 + 5 + 3 = 10。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/paint-house
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PaintTheHouse {

  public static void main(String[] args) {
    //
    int[][] ints = DataBuilder.buildDoubleArray("[[17,2,17],[16,16,5],[14,3,19]]");
    Printer.printDoubleArray(ints);
    int i = new Solution().minCost(ints);
    System.out.println(i);
  }

  static class Solution {
    public int minCost(int[][] costs) {
      //      return method1(costs);
      return method2(costs);
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param costs
     * @return
     */
    private int method1(int[][] costs) {
      if (costs == null || costs.length == 0) return 0;
      int[][] dp = new int[costs.length][3];
      dp[0][0] = costs[0][0];
      dp[0][1] = costs[0][1];
      dp[0][2] = costs[0][2];
      for (int i = 1; i < costs.length; i++) {
        dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
      }
      return Math.min(
          dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }

    /**
     * 空间优化
     *
     * <p>执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param costs
     * @return
     */
    private int method2(int[][] costs) {
      if (costs == null || costs.length == 0) return 0;
      int dp0 = costs[0][0];
      int dp1 = costs[0][1];
      int dp2 = costs[0][2];
      for (int i = 1; i < costs.length; i++) {
        int tempdp0 = Math.min(dp1, dp2) + costs[i][0];
        int tempdp1 = Math.min(dp0, dp2) + costs[i][1];
        int tempdp2 = Math.min(dp0, dp1) + costs[i][2];
        dp0 = tempdp0;
        dp1 = tempdp1;
        dp2 = tempdp2;
      }
      return Math.min(dp0, Math.min(dp1, dp2));
    }
  }
}
