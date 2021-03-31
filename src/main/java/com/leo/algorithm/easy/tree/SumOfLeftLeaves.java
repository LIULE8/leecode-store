// 计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树
// 404. 左叶子之和

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class SumOfLeftLeaves {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 89.85% 的用户
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
      if (root == null) return 0;
      if (root.left != null && root.left.left == null && root.left.right == null)
        return root.left.val + sumOfLeftLeaves(root.right);
      return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
  }
}
