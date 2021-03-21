// 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//
//
//
// 示例 1：
//
//
//
// 输入：[1,1,1,1,1,null,1]
// 输出：true
//
//
// 示例 2：
//
//
//
// 输入：[2,2,2,5,2]
// 输出：false
//
//
//
//
// 提示：
//
//
// 给定树的节点数范围是 [1, 100]。
// 每个节点的值都是整数，范围为 [0, 99] 。
//
// Related Topics 树
// 965. 单值二叉树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class UnivaluedBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 50.12% 的用户
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
      return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int num) {
      if (root == null) return true;
      if (root.val != num) return false;
      return isUnivalTree(root.left, num) && isUnivalTree(root.right, num);
    }
  }
}
