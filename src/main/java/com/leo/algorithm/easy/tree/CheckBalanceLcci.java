// 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
//
//
// 示例 1:
// 给定二叉树 [3,9,20,null,null,15,7]
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 返回 true 。
// 示例 2:
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//      1
//     / \
//    2   2
//   / \
//  3   3
// / \
// 4   4
// 返回 false 。
//
// Related Topics 树 深度优先搜索
// 面试题 04.04. 检查平衡性

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class CheckBalanceLcci {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 85.04% 的用户
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
      if (root == null) return true;
      return Math.abs(height(root.left) - height(root.right)) < 2
          && isBalanced(root.left)
          && isBalanced(root.right);
    }

    private int height(TreeNode root) {
      if (root == null) return 0;
      return Math.max(height(root.left), height(root.right)) + 1;
    }
  }
}
