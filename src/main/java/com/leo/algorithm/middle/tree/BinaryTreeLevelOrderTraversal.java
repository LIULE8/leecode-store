// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
// 二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
// 102. 二叉树的层序遍历
// Related Topics 树 广度优先搜索 二叉树

package com.leo.algorithm.middle.tree;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);
    Printer.printDoubleList(solution.levelOrder(treeNode));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 90.72% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 88.41% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> results = new ArrayList<>();
      if (root == null) return results;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        List<Integer> level = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode poll = queue.poll();
          level.add(poll.val);
          if (poll.left != null) queue.offer(poll.left);
          if (poll.right != null) queue.offer(poll.right);
        }
        results.add(level);
      }
      return results;
    }
  }
}
