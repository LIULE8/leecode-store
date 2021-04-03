// 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
// 给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树
// 543. 二叉树的直径

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class DiameterOfBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {

    private int max = 0;
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 90.06% 的用户
     */
    public int diameterOfBinaryTree(TreeNode root) {
      depth(root);
      return max;
    }

    private int depth(TreeNode root) {
      if (root == null) return 0;
      int left = depth(root.left);
      int right = depth(root.right);
      max = Math.max(max, left + right);
      return Math.max(left, right) + 1;
    }
  }
}
