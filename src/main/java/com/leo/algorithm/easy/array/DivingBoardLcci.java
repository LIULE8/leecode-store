// 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
// 法，生成跳水板所有可能的长度。
// 返回的长度需要从小到大排列。
// 示例：
// 输入：
// shorter = 1
// longer = 2
// k = 3
// 输出： {3,4,5,6}
//
// 提示：
//
// 0 < shorter <= longer
// 0 <= k <= 100000
//
// Related Topics 递归 记忆化
// 面试题 16.11 跳水版

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

public class DivingBoardLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("3,4,5,6", new Solution().divingBoard(1, 2, 3));
    Printer.printCorrectAnswer("6", new Solution().divingBoard(3, 3, 2));
  }

  static class Solution {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了96.09%的用户
     *
     * <p>内存消耗：47.9 MB, 在所有 Java 提交中击败了100.00%的用户
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
      if (k == 0) return new int[0];
      if (shorter == longer) return new int[] {shorter * k};
      int[] a = new int[k + 1];
      for (int i = 0; i <= k; i++) {
        a[i] = shorter * (k - i) + longer * i;
      }
      return a;
    }
  }
}
