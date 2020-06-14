//在一个给定的数组nums中，总是存在一个最大元素 。 
//
// 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。 
//
// 如果是，则返回最大元素的索引，否则返回-1。 
//
// 示例 1: 
//
// 输入: nums = [3, 6, 1, 0]
//输出: 1
//解释: 6是最大的整数, 对于数组中的其他整数,
//6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
// 
//
// 
//
// 示例 2: 
//
// 输入: nums = [1, 2, 3, 4]
//输出: -1
//解释: 4没有超过3的两倍大, 所以我们返回 -1.
// 
//
// 
//
// 提示: 
//
// 
// nums 的长度范围在[1, 50]. 
// 每个 nums[i] 的整数范围在 [0, 100]. 
// 
// Related Topics 数组

package com.leo.easy.array;

import com.leo.utils.DataBuilder;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        System.out.println(new Solution().dominantIndex(DataBuilder.buildIntArray("1, 2, 3, 4"))); //-1
        System.out.println(new Solution().dominantIndex(DataBuilder.buildIntArray("0,0,3,2"))); //-1
        System.out.println(new Solution().dominantIndex(DataBuilder.buildIntArray("0,3,2,0"))); //-1
        System.out.println(new Solution().dominantIndex(DataBuilder.buildIntArray("1"))); //0
        System.out.println(new Solution().dominantIndex(DataBuilder.buildIntArray("3, 6, 1, 0"))); //1
        System.out.println(new Solution().dominantIndex(DataBuilder.buildIntArray("0,0,0,1"))); //3
    }


    static class Solution {
        public int dominantIndex(int[] nums) {
//            return method1(nums);
            return method2(nums);
        }

        private int method2(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int first = nums[0];
            int second = 0;
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if (first < nums[i]) {
                    second = first;
                    first = nums[i];
                    index = i;
                }
            }
            return first >= second + second ? index : -1;
        }

        /**
         * 执行用时 :1 ms, 在所有 Java 提交中击败了54.08%的用户
         * <p>
         * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了6.25%的用户
         *
         * @param nums
         * @return
         */
        private int method1(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int first = nums[0];
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if (first < nums[i]) {
                    first = nums[i];
                    index = i;
                }
            }
            int second = 0;
            for (int num : nums) {
                if (second < num && num != first) {
                    second = num;
                }
            }
            return first >= second + second ? index : -1;
        }
    }

}