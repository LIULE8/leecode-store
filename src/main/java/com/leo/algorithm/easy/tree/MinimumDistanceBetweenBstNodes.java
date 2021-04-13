// 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
//
//
//
// 示例：
//
// 输入: root = [4,2,6,1,3,null,null]
// 输出: 1
// 解释:
// 注意，root是树节点对象(TreeNode object)，而不是数组。
//
// 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
// 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
//
//
//
// 注意：
//
//
// 二叉树的大小范围在 2 到 100。
// 二叉树总是有效的，每个节点的值都是整数，且不重复。
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
// 相同
//
// Related Topics 树 深度优先搜索 递归
// 783. 二叉搜索树节点最小距离

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumDistanceBetweenBstNodes {
  public static void main(String[] args) {
    new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 5.57% 的用户
     *
     * <p>内存消耗： 35.9 MB , 在所有 Java 提交中击败了 77.95% 的用户
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      minDiffInBST(root, list);
      list.sort(Comparator.naturalOrder());
      int min = Integer.MAX_VALUE;
      for (int i = 1; i < list.size(); i++) {
        min = Math.min(min, list.get(i) - list.get(i - 1));
      }
      return min;
    }

    private void minDiffInBST(TreeNode root, List<Integer> list) {
      if (root == null) return;
      list.add(root.val);
      minDiffInBST(root.left, list);
      minDiffInBST(root.right, list);
    }
  }
}
