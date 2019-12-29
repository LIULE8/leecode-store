package com.leo.easy.array;

import com.leo.utils.DataBuilder;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * <p>给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * <p>设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * <p>示例 1:
 *
 * <p>输入: [7,1,5,3,6,4] 输出: 7 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 。   随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。 示例 2:
 *
 * <p>输入: [1,2,3,4,5] 输出: 4 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *   注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。 示例 3:
 *
 * <p>输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockIi {
  public static void main(String[] args) {
    //        int[] ints = DataBuilder.buildIntArray("7,1,2,3,5,1,9"); // 12
    //        int[] ints = DataBuilder.buildIntArray("7,1,5,3,6,4");
    //        int[] ints = DataBuilder.buildIntArray("1,2,3,4,5");
    //        int[] ints = DataBuilder.buildIntArray("5,4,3,2,1");
    //    int[] ints = DataBuilder.buildIntArray("1,2");
    int[] ints = DataBuilder.buildIntArray("1");
    int i = new Solution().maxProfit(ints);
    System.out.println(i);
  }

  static class Solution {
    public int maxProfit(int[] prices) {
      //      return method1(prices);
      //      return method2(prices);
      return method3(prices);
    }

    private int method3(int[] prices) {
      return 0;
    }

    /**
     * 贪心算法
     *
     * <p>执行用时 : 1 ms , 在所有 java 提交中击败了 99.97% 的用户
     *
     * <p>内存消耗 : 37 MB , 在所有 java 提交中击败了 82.17% 的用户
     *
     * @param prices
     * @return
     */
    private int method2(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int sum = 0;
      for (int i = 1; i < prices.length; i++) {
        if (prices[i - 1] < prices[i]) {
          sum += (prices[i] - prices[i - 1]);
        }
      }
      return sum;
    }

    /**
     * 执行用时 : 2 ms , 在所有 java 提交中击败了 23.10% 的用户
     *
     * <p>内存消耗 : 37.1 MB , 在所有 java 提交中击败了 78.00% 的用户
     *
     * @param prices
     * @return
     */
    private int method1(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int sum = 0;
      int dp = prices[0];
      for (int index = 1; index < prices.length; index++) {
        dp = Math.min(dp, prices[index]);
        while (index + 1 < prices.length && prices[index] < prices[index + 1]) index++;
        sum += (prices[index] - dp);
        if (index + 1 >= prices.length) break;
        dp = prices[index + 1]; // 获取下一个为dp，前面的dp已使用
      }
      return sum;
    }
  }
}
