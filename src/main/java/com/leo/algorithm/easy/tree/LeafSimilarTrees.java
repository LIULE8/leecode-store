// 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
//
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
//
// 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
//
//
//
// 示例 1：
//
//
//
// 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,nu
// ll,null,null,null,9,8]
// 输出：true
//
//
// 示例 2：
//
// 输入：root1 = [1], root2 = [1]
// 输出：true
//
//
// 示例 3：
//
// 输入：root1 = [1], root2 = [2]
// 输出：false
//
//
// 示例 4：
//
// 输入：root1 = [1,2], root2 = [2,2]
// 输出：true
//
//
// 示例 5：
//
//
//
// 输入：root1 = [1,2,3], root2 = [1,3,2]
// 输出：false
//
//
//
//
// 提示：
//
//
// 给定的两棵树可能会有 1 到 200 个结点。
// 给定的两棵树上的值介于 0 到 200 之间。
//
// Related Topics 树 深度优先搜索
// 872. 叶子相似的树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 90.47% 的用户
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> l1 = new ArrayList<>();
      leaf(root1, l1);
      List<Integer> l2 = new ArrayList<>();
      leaf(root2, l2);
      if (l1.size() != l2.size()) return false;
      for (int i = 0; i < l1.size(); i++) {
        if (!l1.get(i).equals(l2.get(i))) {
          return false;
        }
      }
      return true;
    }

    private void leaf(TreeNode root, List<Integer> list) {
      if (root == null) return;
      if (root.left == null && root.right == null) {
        list.add(root.val);
        return;
      }
      if (root.left != null) leaf(root.left, list);
      if (root.right != null) leaf(root.right, list);
    }
  }
}
