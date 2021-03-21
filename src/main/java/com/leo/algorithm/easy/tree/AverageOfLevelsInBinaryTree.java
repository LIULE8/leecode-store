// 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//
//
// 示例 1：
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 输出：[3, 14.5, 11]
// 解释：
// 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
//
//
//
//
// 提示：
//
//
// 节点值的范围在32位有符号整数范围内。
//
// Related Topics 树
// 637. 二叉树的层平均值

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 层序遍历
     *
     * <p>执行用时： 4 ms , 在所有 Java 提交中击败了 16.57% 的用户
     *
     * <p>内存消耗： 40.2 MB , 在所有 Java 提交中击败了 78.40% 的用户
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
      List<Double> list = new ArrayList<>();
      if (root == null) return list;
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        double sum = 0, size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode poll = queue.poll();
          sum += poll.val;
          if (poll.left != null) queue.add(poll.left);
          if (poll.right != null) queue.add(poll.right);
        }
        list.add(sum / size);
      }
      return list;
    }
  }
}
