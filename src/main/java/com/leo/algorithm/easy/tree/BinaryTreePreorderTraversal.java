// 给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
// 输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 144. 二叉树的前序遍历

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
  public static void main(String[] args) {
    Printer.printIntegerList(
        new Solution()
            .preorderTraversal(
                DataBuilder.buildTreeNode(DataBuilder.buildIntegerArray("1,null,2,3"))));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 46.26% 的用户
     *
     * <p>内存消耗： 36.4 MB , 在所有 Java 提交中击败了 98.46% 的用户
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
      List<Integer> treeVal = new LinkedList<>();
      TreeNode p = root;
      while (p != null || !stack.empty()) {
        while (p != null) {
          treeVal.add(p.val);
          stack.push(p);
          p = p.left;
        }
        if (!stack.empty()) {
          TreeNode temp = stack.pop();
          p = temp.right;
        }
      }
      return treeVal;
    }
  }
}
