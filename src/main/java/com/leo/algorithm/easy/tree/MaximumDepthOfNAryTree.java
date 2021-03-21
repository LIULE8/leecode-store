// 给定一个 N 叉树，找到其最大深度。
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
//
//
//
// 示例 1：
//
//
//
//
// 输入：root = [1,null,3,2,4,null,5,6]
// 输出：3
//
//
// 示例 2：
//
//
//
//
// 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
// null,13,null,null,14]
// 输出：5
//
//
//
//
// 提示：
//
//
// 树的深度不会超过 1000 。
// 树的节点数目位于 [0, 104] 之间。
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 559. N 叉树的最大深度

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.Node;

public class MaximumDepthOfNAryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.8 MB , 在所有 Java 提交中击败了 14.25% 的用户
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
      if (root == null || root.children == null) return 0;
      int count = 1;
      for (Node child : root.children) {
        count = Math.max(maxDepth(child) + 1, count);
      }
      return count;
    }
  }
}
