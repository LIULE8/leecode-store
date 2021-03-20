// 给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
// 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 递归
// 104. 二叉树的最大深度

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class MaximumDepthOfBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 63.00% 的用户
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
      return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int count) {
      if (root == null) return count;
      count++;
      int d1 = maxDepth(root.left, count);
      int d2 = maxDepth(root.right, count);
      return Math.max(d1, d2);
    }
  }
}
