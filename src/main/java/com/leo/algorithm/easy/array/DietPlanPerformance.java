// 你的好友是一位健身爱好者。前段日子，他给自己制定了一份健身计划。现在想请你帮他评估一下这份计划是否合理。
//
// 他会有一份计划消耗的卡路里表，其中 calories[i] 给出了你的这位好友在第 i 天需要消耗的卡路里总量。
//
// 为了更好地评估这份计划，对于卡路里表中的每一天，你都需要计算他 「这一天以及之后的连续几天」 （共 k 天）内消耗的总卡路里 T：
//
//
// 如果 T < lower，那么这份计划相对糟糕，并失去 1 分；
// 如果 T > upper，那么这份计划相对优秀，并获得 1 分；
// 否则，这份计划普普通通，分值不做变动。
//
//
// 请返回统计完所有 calories.length 天后得到的总分作为评估结果。
//
// 注意：总分可能是负数。
//
//
//
// 示例 1：
//
// 输入：calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
// 输出：0
// 解释：calories[0], calories[1] < lower 而 calories[3], calories[4] > upper, 总分 = 0
// .
//
// 示例 2：
//
// 输入：calories = [3,2], k = 2, lower = 0, upper = 1
// 输出：1
// 解释：calories[0] + calories[1] > upper, 总分 = 1.
//
//
// 示例 3：
//
// 输入：calories = [6,5,0,0], k = 2, lower = 1, upper = 5
// 输出：0
// 解释：calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, 总分 =
// 0.
//
//
//
//
// 提示：
//
//
// 1 <= k <= calories.length <= 10^5
// 0 <= calories[i] <= 20000
// 0 <= lower <= upper
//
// Related Topics 数组 Sliding Window
// 1176. 健身计划评估

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class DietPlanPerformance {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        0, new Solution().dietPlanPerformance(DataBuilder.buildIntArray("1,2,3,4,5"), 1, 3, 3));
    Printer.printCorrectAnswer(
        1, new Solution().dietPlanPerformance(DataBuilder.buildIntArray("3,2"), 2, 0, 1));
    Printer.printCorrectAnswer(
        0, new Solution().dietPlanPerformance(DataBuilder.buildIntArray("6,5,0,0"), 2, 1, 5));
    Printer.printCorrectAnswer(
        3,
        new Solution()
            .dietPlanPerformance(DataBuilder.buildIntArray("6,13,8,7,10,1,12,11"), 6, 5, 37));
    Printer.printCorrectAnswer(
        6,
        new Solution()
            .dietPlanPerformance(
                DataBuilder.buildIntArray("3,10,17,12,19,6,17,4,15,18"), 5, 34, 53));
  }

  static class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
      //      return method1(calories, k, lower, upper);
      return method2(calories, k, lower, upper);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 79.78% 的用户
     *
     * <p>内存消耗： 46.5 MB , 在所有 Java 提交中击败了 70.59% 的用户
     *
     * @param calories
     * @param k
     * @param lower
     * @param upper
     * @return
     */
    private int method2(int[] calories, int k, int lower, int upper) {
      int count = 0;
      int[] res = new int[calories.length - k + 1];
      for (int i = 0; i < k; i++) {
        res[0] += calories[i];
      }
      for (int i = 1; i + k - 1 < calories.length; i++) {
        res[i] = res[i - 1] - calories[i - 1] + calories[i + k - 1];
      }
      for (int num : res) {
        if (num < lower) count--;
        else if (num > upper) count++;
      }
      return count;
    }

    /**
     * 执行用时： 2416 ms , 在所有 Java 提交中击败了 11.24% 的用户
     *
     * <p>内存消耗： 46.8 MB , 在所有 Java 提交中击败了 38.23% 的用户
     *
     * @param calories
     * @param k
     * @param lower
     * @param upper
     * @return
     */
    private int method1(int[] calories, int k, int lower, int upper) {
      int count = 0;
      for (int i = 0; i < calories.length; i += 1) {
        int sum = 0;
        for (int j = i; j < k + i && j < calories.length; j++) {
          sum += calories[j];
        }
        if (sum < lower) count--;
        else if (sum > upper) count++;
        if (i + k >= calories.length) break;
      }
      return count;
    }
  }
}
