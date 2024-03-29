package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;

/**
 * 121. 买卖股票的最佳时机 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * <p>如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * <p>注意你不能在买入股票前卖出股票。
 *
 * <p>示例 1:
 *
 * <p>输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。 示例 2:
 *
 * <p>输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    int[] ints = DataBuilder.buildIntArray("7,1,5,3,6,4");
    //    int[] ints = DataBuilder.buildIntArray("7,6,4,3,1");
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
      if (prices == null || prices.length == 0) return 0;
      int dp = prices[0];
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
        dp = Math.min(prices[i], dp);
        res = Math.max(res, prices[i] - dp);
      }
      return res;
    }

    /**
     * 已 下标i结束的 最小值
     *
     * @param prices
     * @return
     */
    private int method2(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int[] dp = new int[prices.length];
      dp[0] = prices[0];
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
        dp[i] = Math.min(prices[i], dp[i - 1]);
        res = Math.max(res, prices[i] - dp[i]);
      }
      return res;
    }

    private int method1(int[] prices) {
      int max = 0;
      for (int i = 0; i < prices.length - 1; i++) {
        for (int j = i + 1; j < prices.length; j++) {
          int temp = prices[j] - prices[i];
          if (temp > max) {
            max = temp;
          }
        }
      }
      return max;
    }
  }
}
