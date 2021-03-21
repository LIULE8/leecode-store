// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
//
//
// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
// Related Topics 树 广度优先搜索
// 剑指 Offer 32 - II. 从上到下打印二叉树 II

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 94.29% 的用户
     *
     * <p>内存消耗： 38.8 MB , 在所有 Java 提交中击败了 16.99% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode poll = queue.poll();
          list.add(poll.val);
          if (poll.left != null) queue.add(poll.left);
          if (poll.right != null) queue.add(poll.right);
        }
        res.add(list);
      }
      return res;
    }
  }
}
