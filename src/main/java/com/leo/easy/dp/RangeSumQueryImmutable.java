package com.leo.easy.dp;

import com.leo.utils.DataBuilder;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * <p>给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * <p>示例：
 *
 * <p>给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * <p>sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 说明:
 *
 * <p>你可以假设数组不可变。 会多次调用 sumRange 方法。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumQueryImmutable {
  public static void main(String[] args) {
    int[] ints = DataBuilder.buildIntArray("-2,0,3,-5,2,-1");
    NumArray numArray = new NumArray(ints);
    int i1 = numArray.sumRange(0, 2); // 1
    int i2 = numArray.sumRange(2, 5); // -1
    int i3 = numArray.sumRange(0, 5); // -3
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
  }

  /**
   * Your NumArray object will be instantiated and called as such: NumArray obj = new
   * NumArray(nums); int param_1 = obj.sumRange(i,j);
   */
  // leetcode submit region end(Prohibit modification and deletion)
  static class NumArray {

    private int[] nums;

    private Integer[][] dp;

    public NumArray(int[] nums) {
      this.nums = nums;
      dp = new Integer[nums.length][nums.length];
    }

    public int sumRange(int i, int j) {
      if (i >= 0 && i < nums.length && j >= 0 && j < nums.length) {
        if (dp[i][j] != null) return dp[i][j];
        dp[i][i] = nums[i];
        for (int k = i + 1; k <= j; k++) {
          dp[i][k] = dp[i][k - 1] + nums[k];
        }
        return dp[i][j];
      }
      return -1;
    }
  }
}
