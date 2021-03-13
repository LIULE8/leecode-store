// 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pi
// eces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
//
// 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
// 输入：arr = [85], pieces = [[85]]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：arr = [15,88], pieces = [[88],[15]]
// 输出：true
// 解释：依次连接 [15] 和 [88]
//
//
// 示例 3：
//
//
// 输入：arr = [49,18,16], pieces = [[16,18,49]]
// 输出：false
// 解释：即便数字相符，也不能重新排列 pieces[0]
//
//
// 示例 4：
//
//
// 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
// 输出：true
// 解释：依次连接 [91]、[4,64] 和 [78]
//
// 示例 5：
//
//
// 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= pieces.length <= arr.length <= 100
// sum(pieces[i].length) == arr.length
// 1 <= pieces[i].length <= arr.length
// 1 <= arr[i], pieces[i][j] <= 100
// arr 中的整数 互不相同
// pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
//
// Related Topics 排序 数组 哈希表
// 1640. 能否连接形成数组

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canFormArray(DataBuilder.buildIntArray("85"), DataBuilder.buildDoubleArray("[[85]]")));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canFormArray(
                DataBuilder.buildIntArray("15,88"), DataBuilder.buildDoubleArray("[[88],[15]]")));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canFormArray(
                DataBuilder.buildIntArray("91,4,64,78"),
                DataBuilder.buildDoubleArray("[[78],[4,64],[91]]")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .canFormArray(
                DataBuilder.buildIntArray("1,3,5,7"), DataBuilder.buildDoubleArray("[[2,4,6,8]]")));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canFormArray(
                DataBuilder.buildIntArray("2,82,79,95,28"),
                DataBuilder.buildDoubleArray("[[2],[82],[28],[79,95]]")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .canFormArray(
                DataBuilder.buildIntArray("49,18,16"),
                DataBuilder.buildDoubleArray("[[16,18,49]]")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .canFormArray(
                DataBuilder.buildIntArray("1,2,3"), DataBuilder.buildDoubleArray("[[2],[1,3]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 88.51% 的用户
     *
     * <p>内存消耗： 38 MB , 在所有 Java 提交中击败了 12.12% 的用户
     *
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
      Map<Integer, int[]> map = new HashMap<>();
      for (int[] piece : pieces) {
        map.put(piece[0], piece);
      }
      int k = 0;
      while (k < arr.length) {
        if (!map.containsKey(arr[k])) return false;
        for (int num : map.get(arr[k])) {
          if (k + 1 > arr.length || num != arr[k++]) return false;
        }
      }
      return true;
    }
  }
}
