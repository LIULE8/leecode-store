// 给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：2
//
//
// 示例 2：
//
//
// 输入：root = [2,null,3,null,4,null,5,null,6]
// 输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 111. 二叉树的最小深度

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class MinimumDepthOfBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 70.84% 的用户
     *
     * <p>内存消耗： 59.3 MB , 在所有 Java 提交中击败了 29.77% 的用户
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
      if (root == null) return 0;
      if (root.left == null && root.right == null) return 1;
      int min = Integer.MAX_VALUE;
      if (root.left != null) min = Math.min(min, minDepth(root.left));
      if (root.right != null) min = Math.min(min, minDepth(root.right));
      return min + 1;
    }
  }
}
