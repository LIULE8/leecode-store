// 给你一个以行程长度编码压缩的整数列表 nums 。
//
// 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中
// 有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
//
// 请你返回解压后的列表。
//
//
//
// 示例：
//
// 输入：nums = [1,2,3,4]
// 输出：[2,4,4,4]
// 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
// 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
// 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
//
// 示例 2：
//
// 输入：nums = [1,1,2,3]
// 输出：[1,3,3]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 100
// nums.length % 2 == 0
// 1 <= nums[i] <= 100
//
// Related Topics 数组
// 1313. 解压缩编码列表

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
  public static void main(String[] args) {
    Printer.printArray(new Solution().decompressRLElist(DataBuilder.buildIntArray("1,2,3,4")));
    Printer.printArray(new Solution().decompressRLElist(DataBuilder.buildIntArray("1,1,2,3")));
  }

  static class Solution {
    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 18.76% 的用户
     *
     * <p>内存消耗： 40.3 MB , 在所有 Java 提交中击败了 80.99% 的用户
     *
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < nums.length; i += 2) {
        for (int j = 0; j < nums[i]; j++) {
          list.add(nums[i + 1]);
        }
      }
      int[] result = new int[list.size()];
      int k = 0;
      for (Integer val : list) {
        result[k++] = val;
      }
      return result;
    }
  }
}
