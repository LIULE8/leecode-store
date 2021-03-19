// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
// 1 3 6 9
// 镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
// 9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树
// 剑指 Offer 27. 二叉树的镜像

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class ErChaShuDeJingXiangLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public TreeNode mirrorTree(TreeNode root) {
      return method1(root);
    }

    /**
     * 递归算法
     *
     * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.8 MB , 在所有 Java 提交中击败了 52.94% 的用户
     *
     * @param root
     * @return
     */
    private TreeNode method1(TreeNode root) {
      if (root == null) return null;
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      mirrorTree(root.left);
      mirrorTree(root.right);
      return root;
    }
  }
}
