// 给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
// 2     3
// \
//  5
//
// 输出: ["1->2->5", "1->3"]
//
// 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 257. 二叉树的所有路径

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 27.82% 的用户
     *
     * <p>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 51.79% 的用户
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
      List<String> list = new ArrayList<>();
      dfs(root, "", list);
      return list;
    }

    private void dfs(TreeNode root, String path, List<String> list) {
      if (root == null) return;
      path += root.val;
      if (root.left == null && root.right == null) {
        list.add(path);
        return;
      }
      if (root.left != null) dfs(root.left, path + "->", list);
      if (root.right != null) dfs(root.right, path + "->", list);
    }
  }
}
