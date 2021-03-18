// 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
//
// 示例:
// 给定有序数组: [-10,-3,0,5,9],
//
// 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//          0
//         / \
//       -3   9
//       /   /
//     -10  5
//
// Related Topics 树 深度优先搜索
// 面试题 04.02. 最小高度树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MinimumHeightTreeLcci {
  public static void main(String[] args) {
    Printer.printTreeNode(
        new Solution().sortedArrayToBST(DataBuilder.buildIntArray("-10,-3,0,5,9")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 45.96% 的用户
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
      return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
      if (left == right) {
        return null;
      }
      int mid = left + ((right - left) >> 1);
      TreeNode treeNode = new TreeNode(nums[mid]);
      treeNode.left = sortedArrayToBST(nums, left, mid);
      treeNode.right = sortedArrayToBST(nums, mid + 1, right);
      return treeNode;
    }
  }
}
