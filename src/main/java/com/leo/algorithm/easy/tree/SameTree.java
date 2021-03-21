// 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//
//
// 示例 1：
//
//
// 输入：p = [1,2,3], q = [1,2,3]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：p = [1,2], q = [1,null,2]
// 输出：false
//
//
// 示例 3：
//
//
// 输入：p = [1,2,1], q = [1,1,2]
// 输出：false
//
//
//
//
// 提示：
//
//
// 两棵树上的节点数目都在范围 [0, 100] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索
// 100. 相同的树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

public class SameTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.8 MB , 在所有 Java 提交中击败了 69.78% 的用户
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) return true;
      if (p != null && q != null) {
        if (p.val == q.val && isSameTree(p.left, q.left)) {
          return isSameTree(p.right, q.right);
        } else {
          return false;
        }
      }
      return false;
    }
  }
}
