// 给定一棵二叉搜索树，请找出其中第k大的节点。
//
//
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//    2
// 输出: 4
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
// 输出: 4
//
//
//
// 限制：
//
// 1 ≤ k ≤ 二叉搜索树元素个数
// Related Topics 树
// 剑指 Offer 54. 二叉搜索树的第k大节点

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        4,
        new Solution()
            .kthLargest(
                DataBuilder.buildTreeNode(DataBuilder.buildIntegerArray("3,1,4,null,2")), 1));
  }

  static class Solution {
    private int result = 0, count = 0;

    public int kthLargest(TreeNode root, int k) {
      //      return method1(root, k);
      return method2(root, k);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 74.87% 的用户
     *
     * @param root
     * @param k
     * @return
     */
    private int method2(TreeNode root, int k) {
      count = k;
      if (root != null) {
        dfs(root);
      }
      return result;
    }

    private void dfs(TreeNode root) {
      if (root.right != null && count > 0) dfs(root.right);
      if (--count == 0) {
        result = root.val;
        return;
      }
      if (root.left != null && count > 0) dfs(root.left);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 41.69% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 11.46% 的用户
     *
     * @param root
     * @param k
     * @return
     */
    private int method1(TreeNode root, int k) {
      List<Integer> list = new ArrayList<>();
      kthLargest(root, list);
      return list.get(list.size() - k);
    }

    private void kthLargest(TreeNode root, List<Integer> list) {
      if (root == null) return;
      if (root.left != null) kthLargest(root.left, list);
      list.add(root.val);
      if (root.right != null) kthLargest(root.right, list);
    }
  }
}
