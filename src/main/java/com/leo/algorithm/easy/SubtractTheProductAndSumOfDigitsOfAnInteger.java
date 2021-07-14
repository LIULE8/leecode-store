package com.leo.algorithm.easy;

/**
 * 1281. 整数的各位积和之差
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
//        int i = new Solution().subtractProductAndSum(234);
        int i = new Solution().subtractProductAndSum(4421);
        System.out.println(i);
    }


    static class Solution {
        public int subtractProductAndSum(int n) {
            int first = 1;
            int second = 0;
            while (n != 0) {
                int c = n % 10;
                first *= c;
                second += c;
                n = n / 10;
            }
            return first - second;
        }
    }
}