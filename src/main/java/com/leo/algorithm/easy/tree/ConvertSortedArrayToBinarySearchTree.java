// 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
// 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
// 108. 将有序数组转换为二叉搜索树
package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ConvertSortedArrayToBinarySearchTree {
  public static void main(String[] args) {
    int[] nums = DataBuilder.buildIntArray("-10,-3,0,5,9");
    TreeNode treeNode = new Solution().sortedArrayToBST(nums);
    Printer.printTreeNode(treeNode);
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 8.70% 的用户
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) return null;
      return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
      if (l > r) {
        return null;
      }
      int mid = (l + r + 1) / 2;
      TreeNode treeNode = new TreeNode(nums[mid]);
      treeNode.left = sortedArrayToBST(nums, l, mid - 1);
      treeNode.right = sortedArrayToBST(nums, mid + 1, r);
      return treeNode;
    }
  }
}
