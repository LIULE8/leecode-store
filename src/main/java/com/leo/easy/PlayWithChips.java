package com.leo.easy;

import com.leo.utils.DataBuilder;

/**
 * 1217. 玩筹码
 *
 * <p>数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 *
 * <p>你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 * <p>将第 i 个筹码向左或者右移动 2 个单位，代价为 0。 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 *
 * <p>返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：chips = [1,2,3] 输出：1 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。 示例 2：
 *
 * <p>输入：chips = [2,2,2,3,3] 输出：2 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 *
 * <p>提示：
 *
 * <p>1 <= chips.length <= 100 1 <= chips[i] <= 10^9
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/play-with-chips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlayWithChips {
  public static void main(String[] args) {
//    int[] ints = DataBuilder.buildIntArray("1,2,3");
    int[] ints = DataBuilder.buildIntArray("2,2,2,3,3");
    int i = new Solution().minCostToMoveChips(ints);
    System.out.println(i);
  }

  static class Solution {
    public int minCostToMoveChips(int[] chips) {
      int odd = 0;
      int even = 0;
      for (int chip : chips) {
        if (chip % 2 == 0) {
          even++;
          continue;
        }
        odd++;
      }
      return Math.min(odd, even);
    }
  }
}
