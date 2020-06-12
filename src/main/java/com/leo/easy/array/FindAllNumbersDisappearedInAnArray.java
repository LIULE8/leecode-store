// 给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
//
// 示例:
//
//
// 输入:
// [4,3,2,7,8,2,3,1]
//
// 输出:
// [5,6]
//
// Related Topics 数组

package com.leo.easy.array;

import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
  public static void main(String[] args) {
    List<Integer> disappearedNumbers =
        new Solution().findDisappearedNumbers(DataBuilder.buildIntArray("4,3,2,7,8,2,3,1"));
    Printer.printIntegerList(disappearedNumbers);
  }

  static class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时 :23 ms, 在所有 Java 提交中击败了20.04%的用户
     *
     * <p>内存消耗 :48.7 MB, 在所有 Java 提交中击败了45.83%的用户
     *
     * @param nums
     * @return
     */
    private List<Integer> method2(int[] nums) {
      List<Integer> list = new ArrayList<>();
      if (nums == null || nums.length == 0) return list;
      HashSet<Integer> set = new HashSet<>();
      for (int i = 1; i <= nums.length; i++) {
        set.add(nums[i - 1]);
      }
      for (int i = 1; i <= nums.length; i++) {
        if (!set.contains(i)) {
          list.add(i);
        }
      }
      return list;
    }

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了88.92%的用户
     *
     * <p>内存消耗 :48.9 MB, 在所有 Java 提交中击败了37.50%的用户
     *
     * @param nums
     * @return
     */
    private List<Integer> method1(int[] nums) {
      List<Integer> list = new ArrayList<>();
      if (nums == null || nums.length == 0) return list;
      for (int i = 1; i <= nums.length; i++) {
        int index = Math.abs(nums[i - 1]);
        if (nums[index - 1] > 0) {
          nums[index - 1] *= -1;
        }
      }
      for (int i = 1; i <= nums.length; i++) {
        if (nums[i - 1] > 0) {
          list.add(i);
        }
      }
      return list;
    }
  }
}
