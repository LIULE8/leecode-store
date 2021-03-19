// 翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
// 1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
// 9   6 3   1
//
// 备注:
// 这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
// 226. 翻转二叉树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class InvertBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.9 MB , 在所有 Java 提交中击败了 43.19% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      TreeNode tmp = root.left;
      root.left = root.right;
      root.right = tmp;
      invertTree(root.left);
      invertTree(root.right);
      return root;
    }
  }
}
