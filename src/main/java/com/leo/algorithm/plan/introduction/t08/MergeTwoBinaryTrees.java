// 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
// 。
//
// 示例 1:
//
//
// 输入:
//	Tree 1                     Tree 2
//          1                         2
//         / \                       / \
//        3   2                     1   3
//       /                           \   \
//      5                             4   7
// 输出:
// 合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \
//	 5   4   7
//
//
// 注意: 合并必须从两个树的根节点开始。
// Related Topics 树
// 617. 合并二叉树

package com.leo.algorithm.plan.introduction.t08;

import com.leo.algorithm.structure.TreeNode;

public class MergeTwoBinaryTrees {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      return method1(root1, root2);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 21.27% 的用户
     *
     * @param root1
     * @param root2
     * @return
     */
    private TreeNode method1(TreeNode root1, TreeNode root2) {
      if (root1 == null) return root2;
      if (root2 == null) return root1;
      root1.val += root2.val;
      root1.left = mergeTrees(root1.left, root2.left);
      root1.right = mergeTrees(root1.right, root2.right);
      return root1;
    }
  }
}
