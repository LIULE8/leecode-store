// 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
// ，不能则返回False。
//
// 示例 1:
//
//
// 输入: flowerbed = [1,0,0,0,1], n = 1
// 输出: True
//
//
// 示例 2:
//
//
// 输入: flowerbed = [1,0,0,0,1], n = 2
// 输出: False
//
//
// 注意:
//
//
// 数组内已种好的花不会违反种植规则。
// 输入的数组长度范围为 [1, 20000]。
// n 是非负整数，且不会超过输入数组的大小。
//
// Related Topics 数组
// 605. 种花问题

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class CanPlaceFlowers {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().canPlaceFlowers(DataBuilder.buildIntArray("1,0,0,0,1"), 1));
    Printer.printCorrectAnswer(
        false, new Solution().canPlaceFlowers(DataBuilder.buildIntArray("1,0,0,0,1"), 2));
    Printer.printCorrectAnswer(
        false, new Solution().canPlaceFlowers(DataBuilder.buildIntArray("0,1,0,1,0"), 1));
    Printer.printCorrectAnswer(
        true, new Solution().canPlaceFlowers(DataBuilder.buildIntArray("0"), 1));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 41.1 MB , 在所有 Java 提交中击败了 76.87% 的用户
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      if (flowerbed == null || flowerbed.length == 0) return false;
      if (flowerbed.length == 1 && flowerbed[0] == 0) return true;
      int count = 0;
      for (int i = 0; i < flowerbed.length; i++) {
        if (i == 0) {
          if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
            count++;
            flowerbed[i] = 1;
          }
          continue;
        }
        if (i == flowerbed.length - 1) {
          if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
            count++;
            flowerbed[i] = 1;
          }
          continue;
        }
        if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1 && flowerbed[i] == 0) {
          count++;
          flowerbed[i] = 1;
        }
      }
      return count >= n;
    }
  }
}
