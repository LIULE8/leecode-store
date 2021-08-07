// 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
// 意数字。A 不能视为 14。
//
//
//
// 示例 1:
//
// 输入: [1,2,3,4,5]
// 输出: True
//
//
//
// 示例 2:
//
// 输入: [0,0,1,2,5]
// 输出: True
//
//
//
// 限制：
//
// 数组长度为 5
//
// 数组的数取值为 [0, 13] .
// Related Topics 数组 排序
// 剑指 Offer 61. 扑克牌中的顺子

package com.leo.algorithm.easy.array;

import java.util.Arrays;

public class BuKePaiZhongDeShunZiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 19.61% 的用户
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
      Arrays.sort(nums);
      int count = 0;
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == 0) {
          count++;
          continue;
        }
        if (nums[i + 1] == nums[i]) return false;
        int tmp = nums[i + 1] - nums[i] - 1;
        if (tmp > count) return false;
        else count -= tmp;
      }
      return true;
    }
  }
}
