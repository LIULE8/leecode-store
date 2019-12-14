package com.leo.easy;

import com.leo.utils.Printer;

/**
 * 189 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        new Solution().rotate(nums, 3);
        int[] nums = new int[]{-1, -100, 3, 99}; // 3,99,-1,-100
        new Solution().rotate(nums, 2);
//        int[] nums = new int[]{1, 2}; // 2,1
//        new Solution().rotate(nums, 3);
        Printer.printArray(nums);
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 1) {
                return;
            }
            for (int i = 0; i < k; i++) {
                for (int j = nums.length - 1; j > 0; j--) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}