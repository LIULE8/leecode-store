// 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
// 案例 1:
//
//
// 输入:
//    5
//   / \
//  3   6
// / \   \
// 2   4   7
//
// Target = 9
//
// 输出: True
//
//
//
//
// 案例 2:
//
//
// 输入:
//    5
//   / \
//  3   6
// / \   \
// 2   4   7
//
// Target = 28
//
// 输出: False
//
//
//
// Related Topics 树
// 653. 两数之和 IV - 输入 BST

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIvInputIsABst {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public boolean findTarget(TreeNode root, int k) {
      Set<Integer> set = new HashSet<Integer>();
      return preOrder(root, set, k);
    }

    private boolean preOrder(TreeNode root, Set<Integer> set, int k) {
      if (root == null) return false;
      if (set.contains(k - root.val)) {
        return true;
      }
      set.add(root.val);
      return preOrder(root.left, set, k) || preOrder(root.right, set, k);
    }
  }
}
