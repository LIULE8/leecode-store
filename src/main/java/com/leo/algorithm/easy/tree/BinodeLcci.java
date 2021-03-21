// 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
// 搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
//
// 返回转换后的单向链表的头节点。
//
// 注意：本题相对原题稍作改动
//
//
//
// 示例：
//
// 输入： [4,2,5,1,3,null,6,0]
// 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
//
//
// 提示：
//
//
// 节点数量不会超过 100000。
//
// Related Topics 树 二叉搜索树 递归
// 面试题 17.12. BiNode

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class BinodeLcci {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {

    private TreeNode cur;

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 82.77% 的用户
     *
     * <p>内存消耗： 44.3 MB , 在所有 Java 提交中击败了 14.59% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode convertBiNode(TreeNode root) {
      TreeNode newRoot = new TreeNode(0);
      cur = newRoot;
      dfs(root);
      return newRoot.right;
    }

    private void dfs(TreeNode root) {
      if (root == null) return;
      dfs(root.left);
      root.left = null;
      cur.right = root;
      cur = cur.right;
      dfs(root.right);
    }
  }
}
