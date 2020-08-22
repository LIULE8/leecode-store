// 给你一个由一些多米诺骨牌组成的列表 dominoes。
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且
// b==c。
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。
//
//
//
// 示例：
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
// 输出：1
//
//
//
//
// 提示：
//
//
// 1 <= dominoes.length <= 40000
// 1 <= dominoes[i][j] <= 9
//
// Related Topics 数组
// 1128. 等价多米诺骨牌对的数量

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        1,
        new Solution()
            .numEquivDominoPairs(DataBuilder.buildDoubleArray("[[1,2],[2,1],[3,4],[5,6]]")));
    Printer.printCorrectAnswer(
        0,
        new Solution()
            .numEquivDominoPairs(DataBuilder.buildDoubleArray("[[1,2],[7,8],[3,4],[5,6]]")));
    Printer.printCorrectAnswer(
        3,
        new Solution()
            .numEquivDominoPairs(DataBuilder.buildDoubleArray("[[1,2],[1,2],[1,1],[1,2],[2,2]]")));
    Printer.printCorrectAnswer(
        15,
        new Solution()
            .numEquivDominoPairs(
                DataBuilder.buildDoubleArray("[[2,1],[1,2],[1,2],[1,2],[2,1],[1,1],[1,2],[2,2]]")));
  }

  static class Solution {
    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 29.92% 的用户
     *
     * <p>内存消耗： 48.9 MB , 在所有 Java 提交中击败了 88.46% 的用户
     *
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] dominoe : dominoes) {
        Integer key =
            dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
        map.put(key, map.getOrDefault(key, 0) + 1);
      }

      int sum = 0;
      for (Integer value : map.values()) {
        sum += value * (value - 1) >> 1;
      }
      return sum;
    }
  }
}
