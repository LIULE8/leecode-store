// 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
//
//
// 目标数组 target 最初为空。
// 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
// 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
//
//
// 请你返回目标数组。
//
// 题目保证数字插入位置总是存在。
//
//
//
// 示例 1：
//
// 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
// 输出：[0,4,1,3,2]
// 解释：
// nums       index     target
// 0            0        [0]
// 1            1        [0,1]
// 2            2        [0,1,2]
// 3            2        [0,1,3,2]
// 4            1        [0,4,1,3,2]
//
//
// 示例 2：
//
// 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
// 输出：[0,1,2,3,4]
// 解释：
// nums       index     target
// 1            0        [1]
// 2            1        [1,2]
// 3            2        [1,2,3]
// 4            3        [1,2,3,4]
// 0            0        [0,1,2,3,4]
//
//
// 示例 3：
//
// 输入：nums = [1], index = [0]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length, index.length <= 100
// nums.length == index.length
// 0 <= nums[i] <= 100
// 0 <= index[i] <= i
//
// Related Topics 数组
// 1389. 按既定顺序创建目标数组

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution()
            .createTargetArray(
                DataBuilder.buildIntArray("0,1,2,3,4"), DataBuilder.buildIntArray("0,1,2,2,1")));
    Printer.printArray(
        new Solution()
            .createTargetArray(
                DataBuilder.buildIntArray("1,2,3,4,0"), DataBuilder.buildIntArray("0,1,2,3,0")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 87.84% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param nums
     * @param index
     * @return
     */
    public int[] createTargetArray(int[] nums, int[] index) {
      int[] res = new int[nums.length];
      Arrays.fill(res, -1);
      for (int i = 0; i < nums.length; i++) {
        if (res[index[i]] != -1) {
          insertTarget(res, index[i], nums[i]);
        } else res[index[i]] = nums[i];
      }
      return res;
    }

    private void insertTarget(int[] res, int start, int target) {
      for (int i = res.length - 1; i >= start; --i) {
        if (res[i] == -1) continue;
        res[i + 1] = res[i];
      }
      res[start] = target;
    }
  }
}
