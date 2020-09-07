// 给你个整数数组 arr，其中每个元素都 不相同。
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
//
//
//
// 示例 1：
//
// 输入：arr = [4,2,1,3]
// 输出：[[1,2],[2,3],[3,4]]
//
//
// 示例 2：
//
// 输入：arr = [1,3,6,10,15]
// 输出：[[1,3]]
//
//
// 示例 3：
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
// 输出：[[-14,-10],[19,23],[23,27]]
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 10^5
// -10^6 <= arr[i] <= 10^6
//
// Related Topics 数组
// 1200. 最小绝对差

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
  public static void main(String[] args) {
    Printer.printDoubleList(
        new Solution().minimumAbsDifference(DataBuilder.buildIntArray("4,2,1,3")));
    Printer.printDoubleList(
        new Solution().minimumAbsDifference(DataBuilder.buildIntArray("1,3,6,10,15")));
    Printer.printDoubleList(
        new Solution().minimumAbsDifference(DataBuilder.buildIntArray("3,8,-10,23,19,-4,-14,27")));
  }

  static class Solution {
    /**
     * 执行用时： 20 ms , 在所有 Java 提交中击败了 41.23% 的用户
     *
     * <p>内存消耗： 50.8 MB , 在所有 Java 提交中击败了 59.39% 的用户
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
      Arrays.sort(arr);
      List<List<Integer>> list = new ArrayList<>();
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < arr.length - 1; i++) {
        int abs = Math.abs(arr[i] - arr[i + 1]);
        if (min > abs) {
          list.clear();
          list.add(Arrays.asList(arr[i], arr[i + 1]));
          min = abs;
        } else if (min == abs) {
          list.add(Arrays.asList(arr[i], arr[i + 1]));
        }
      }
      return list;
    }
  }
}
