// 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
// 做它自身的一棵子树。
//
// 示例 1:
// 给定的树 s:
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//
//
// 给定的树 t：
//
//
//   4
//  / \
// 1   2
//
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
// 示例 2:
// 给定的树 s：
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//
//
// 给定的树 t：
//
//
//   4
//  / \
// 1   2
//
//
// 返回 false。
// Related Topics 树
// 572. 另一个树的子树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class SubtreeOfAnotherTree {
  public static void main(String[] args) {
    new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 79.64% 的用户
     *
     * <p>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 33.23% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
      return dfs(s, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
      if (s == null) return false;
      return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
      if (s == null && t == null) return true;
      if (s == null || t == null || s.val != t.val) return false;
      return check(s.left, t.left) && check(s.right, t.right);
    }
  }
}
