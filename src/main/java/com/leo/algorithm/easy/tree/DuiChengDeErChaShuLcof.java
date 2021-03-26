// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
// 3 4 4 3
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树
// 剑指 Offer 28. 对称的二叉树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class DuiChengDeErChaShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 80.25% 的用户
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;
      return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
      if ((left == null && right != null) || (left != null && right == null)) return false;
      else if (left == null) return true;
      else if (left.val != right.val) return false;
      return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
  }
}
