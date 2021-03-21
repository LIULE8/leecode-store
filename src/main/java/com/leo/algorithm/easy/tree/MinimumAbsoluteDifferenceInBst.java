// 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
// 输出：
// 1
//
// 解释：
// 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
// 相同
//
// Related Topics 树
// 530. 二叉搜索树的最小绝对差

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {

    public int getMinimumDifference(TreeNode root) {
      return method1(root);
    }

    /**
     * 执行用时： 188 ms , 在所有 Java 提交中击败了 5.46% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 15.36% 的用户
     *
     * @param root
     * @return
     */
    private int method1(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      getMinimumDifference(root, list);
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < list.size() - 1; i++) {
        for (int j = i + 1; j < list.size(); j++) {
          min = Math.min(min, Math.abs(list.get(i) - list.get(j)));
        }
      }
      return min;
    }

    private void getMinimumDifference(TreeNode root, List<Integer> list) {
      if (root == null) return;
      if (root.left != null) getMinimumDifference(root.left, list);
      list.add(root.val);
      if (root.right != null) getMinimumDifference(root.right, list);
    }
  }
}
