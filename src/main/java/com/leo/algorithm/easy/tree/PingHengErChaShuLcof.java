// 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
// 示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
//
// 限制：
//
//
// 0 <= 树的结点个数 <= 10000
//
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
//
//
// Related Topics 树 深度优先搜索
// 剑指 Offer 55 - II. 平衡二叉树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class PingHengErChaShuLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .isBalanced(
                DataBuilder.buildTreeNode(DataBuilder.buildIntegerArray("3,9,20,null,null,15,7"))));
  }

  static class Solution {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 96.18% 的用户
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
      return recur(root) != -1;
    }

    private int recur(TreeNode root) {
      if (root == null) return 0;
      int d1 = recur(root.left);
      if (d1 == -1) return -1;
      int d2 = recur(root.right);
      if (d2 == -1) return -1;
      return Math.abs(d1 - d2) < 2 ? Math.max(d1, d2) + 1 : -1;
    }
  }
}
