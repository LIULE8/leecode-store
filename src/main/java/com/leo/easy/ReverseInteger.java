//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

package com.leo.easy;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int reverse = solution.reverse(1463847412);
//        int reverse = solution.reverse(463847412);
        int reverse = solution.reverse(-1534236469);
        System.out.println(reverse);
    }


    static class Solution {
        public int reverse(int x) {
            return method2(x);
//            return method1(x);
        }

        /**
         * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         * <p>
         * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了5.33%的用户
         *
         * @param x
         * @return
         */
        private int method2(int x) {
            int flag = (x < 0) ? -1 : 1;
            x = Math.abs(x);
            long result = 0;
            while (x > 0) {
                result = result * 10 + (x % 10);
                x /= 10;
            }
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) result * flag;
        }

        /**
         * 执行用时 :2 ms, 在所有 Java 提交中击败了41.55%的用户
         * <p>
         * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.33%的用户
         *
         * @param x
         * @return
         */
        private int method1(int x) {
            int flag = (x < 0) ? -1 : 1;
            x = Math.abs(x);
            int result = 0;
            int i = Integer.MAX_VALUE / 10;
            while (x > 0) {
                if (i < result || i == result && x % 10 > 7) {
                    return 0;
                }
                result = result * 10 + (x % 10);
                x /= 10;
            }
            return result * flag;
        }
    }

}