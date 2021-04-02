// 给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
// 3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 101. 对称二叉树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class SymmetricTree {
  public static void main(String[] args) {
    new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 28.10% 的用户
     *
     * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 90.86% 的用户
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;
      return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
      if (left == null && right != null || left != null && right == null) return false;
      else if (left == null) return true;
      else if (left.val != right.val) return false;
      return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
  }
}
