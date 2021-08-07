// 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//
//
// 示例 1：
//
// 输入：target = 9
// 输出：[[2,3,4],[4,5]]
//
//
// 示例 2：
//
// 输入：target = 15
// 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
//
//
//
// 限制：
//
//
// 1 <= target <= 10^5
//
//
//
// Related Topics 数学 双指针 枚举
// 剑指 Offer 57 - II. 和为s的连续正数序列

package com.leo.algorithm.easy.array;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 滑动窗口
     *
     * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 97.67% 的用户
     *
     * <p>内存消耗： 36.2 MB , 在所有 Java 提交中击败了 88.92% 的用户
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
      int left = 1;
      int right = 1;
      int sum = 0;
      List<int[]> list = new ArrayList<>();
      while (left <= (target >> 1)) {
        // sum 小于 target 的时候 右边界往右移
        if (sum < target) {
          sum += right;
          right++;
        } else if (sum > target) {
          // sum 大于 target 的时候 左边界往右移
          sum -= left;
          left++;
        } else {
          int[] arr = new int[right - left];
          for (int i = left; i < right; i++) {
            arr[i - left] = i;
          }
          list.add(arr);
          // 同样左边界往右移
          sum -= left;
          left++;
        }
      }
      return list.toArray(new int[list.size()][]);
    }
  }
}
