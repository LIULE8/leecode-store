package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = DataBuilder.buildIntArray("1,2,3,0,0,0");
        int[] nums2 = DataBuilder.buildIntArray("2,5,6");
        new Solution().merge(nums1, 3, nums2, 3);
//        int[] nums1 = DataBuilder.buildIntArray("0");
//        int[] nums2 = DataBuilder.buildIntArray("1");
//        new Solution().merge(nums1, 0, nums2, 1);
        Printer.printArray(nums1);
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            method1(nums1, m, nums2, n);
            method2(nums1, m, nums2, n);
        }

        private void method2(int[] nums1, int m, int[] nums2, int n) {
            int i = m-- + --n;
            while (m >= 0 && n >= 0) {
                nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
            while (n >= 0) {
                nums1[i--] = nums2[n--];
            }
        }

        private void method1(int[] nums1, int m, int[] nums2, int n) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }
}