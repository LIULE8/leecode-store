// 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
// 例如：
//
// 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
//
//
//
// 提示：
//
//
// 节点总数 <= 10000
//
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
// e/
// Related Topics 树 深度优先搜索
// 剑指 Offer 55 - I. 二叉树的深度

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class ErChaShuDeShenDuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public int maxDepth(TreeNode root) {
      return maxDepth(root, 0);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 10.06% 的用户
     *
     * @param root
     * @param depth
     * @return
     */
    private int maxDepth(TreeNode root, int depth) {
      if (root == null) {
        return depth;
      }
      depth++;
      int d1 = maxDepth(root.left, depth);
      int d2 = maxDepth(root.right, depth);
      return Math.max(d1, d2);
    }
  }
}
