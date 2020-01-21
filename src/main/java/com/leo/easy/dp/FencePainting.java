package com.leo.easy.dp;

/**
 * 276. 栅栏涂色
 *
 * <p>有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 *
 * <p>你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。
 *
 * <p>注意: n 和 k 均为非负的整数。
 *
 * <p>示例:
 *
 * <p>输入: n = 3，k = 2
 *
 * <p>输出: 6
 *
 * <p>解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:
 *
 * <p>  柱 1 柱 2 柱 3
 *
 * <p>----- ----- ----- -----
 *
 * <p>1 c1 c1 c2
 *
 * <p>2 c1 c2 c1
 *
 * <p>3 c1 c2 c2
 *
 * <p>4 c2 c1 c1
 *
 * <p>5 c2 c1 c2
 *
 * <p>6 c2 c2 c1
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/paint-fence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FencePainting {
  public static void main(String[] args) {
    //    int i = new Solution().numWays(3, 2); //6
    //    int i = new Solution().numWays(2, 1); //1
    //    int i = new Solution().numWays(4, 3); // 66
    int i = new Solution().numWays(1, 2); // 2
    System.out.println(i);
  }

  static class Solution {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 33.3 MB , 在所有 Java 提交中击败了 5.19% 的用户
     *
     * @param n 柱子数
     * @param k 颜色数
     * @return
     */
    public int numWays(int n, int k) {
      if (n == 0 || k == 0) return 0;
      if (n == 1) return k;
      int diff = k * (k - 1);
      int same = k;
      for (int i = 2; i < n; i++) {
        int temp = diff;
        diff = (diff + same) * (k - 1);
        same = temp;
      }
      return diff + same;
    }
  }
}
