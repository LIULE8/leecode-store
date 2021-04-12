// 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
// 个。
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
//
//
//
// 示例 1：
//
//
// 输入：root = [2,2,5,null,null,5,7]
// 输出：5
// 解释：最小的值是 2 ，第二小的值是 5 。
//
//
// 示例 2：
//
//
// 输入：root = [2,2,2]
// 输出：-1
// 解释：最小的值是 2, 但是不存在第二小的值。
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 25] 内
// 1 <= Node.val <= 231 - 1
// 对于树中每个节点 root.val == min(root.left.val, root.right.val)
//
// Related Topics 树
// 671. 二叉树中第二小的节点

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class SecondMinimumNodeInABinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.8 MB , 在所有 Java 提交中击败了 34.14% 的用户
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
      if (root == null) return -1;
      return findSecondMinimumValue(root, root.val);
    }

    private int findSecondMinimumValue(TreeNode root, int val) {
      if (root == null) return -1;
      if (root.val > val) return root.val;
      int d1 = findSecondMinimumValue(root.right, val);
      int d2 = findSecondMinimumValue(root.left, val);
      if (d1 == -1) return d2;
      if (d2 == -1) return d1;
      return Math.min(d1, d2);
    }
  }
}
