// 给你两个长度相同的整数数组 target 和 arr 。
//
// 每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
//
// 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
//
//
//
// 示例 1：
//
// 输入：target = [1,2,3,4], arr = [2,4,1,3]
// 输出：true
// 解释：你可以按照如下步骤使 arr 变成 target：
// 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
// 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
// 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
// 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
//
//
// 示例 2：
//
// 输入：target = [7], arr = [7]
// 输出：true
// 解释：arr 不需要做任何翻转已经与 target 相等。
//
//
// 示例 3：
//
// 输入：target = [1,12], arr = [12,1]
// 输出：true
//
//
// 示例 4：
//
// 输入：target = [3,7,9], arr = [3,7,11]
// 输出：false
// 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
//
//
// 示例 5：
//
// 输入：target = [1,1,1,1,1], arr = [1,1,1,1,1]
// 输出：true
//
//
//
//
// 提示：
//
//
// target.length == arr.length
// 1 <= target.length <= 1000
// 1 <= target[i] <= 1000
// 1 <= arr[i] <= 1000
//
// Related Topics 数组
// 1460. 通过翻转子数组使两个数组相等

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MakeTwoArraysEqualByReversingSubArrays {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canBeEqual(
                DataBuilder.buildIntArray("1,2,3,4"), DataBuilder.buildIntArray("2,4,1,3")));
    Printer.printCorrectAnswer(
        true,
        new Solution().canBeEqual(DataBuilder.buildIntArray("7"), DataBuilder.buildIntArray("7")));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canBeEqual(DataBuilder.buildIntArray("1,12"), DataBuilder.buildIntArray("12,1")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .canBeEqual(DataBuilder.buildIntArray("3,7,9"), DataBuilder.buildIntArray("3,7,11")));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .canBeEqual(
                DataBuilder.buildIntArray("1,1,1,1,1"), DataBuilder.buildIntArray("1,1,1,1,1")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .canBeEqual(
                DataBuilder.buildIntArray("1,2,2,3"), DataBuilder.buildIntArray("1,1,2,3")));
  }

  static class Solution {
    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 20.98% 的用户
     *
     * <p>内存消耗： 40 MB , 在所有 Java 提交中击败了 13.90% 的用户
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
      if (target.length == 1 && arr.length == 1) return target[0] == arr[0];
      Map<Integer, Integer> m1 = buildSet(target);
      Map<Integer, Integer> m2 = buildSet(arr);
      Set<Integer> s1 = m1.keySet();
      Set<Integer> s2 = m2.keySet();
      if (s1.size() != s2.size()) return false;
      for (Integer s : s1) {
        if (!m1.get(s).equals(m2.get(s))) return false;
      }
      return true;
    }

    private Map<Integer, Integer> buildSet(int[] target) {
      Map<Integer, Integer> m = new HashMap<>();
      for (int j : target) {
        m.put(j, m.getOrDefault(j, 0) + 1);
      }
      return m;
    }
  }
}
