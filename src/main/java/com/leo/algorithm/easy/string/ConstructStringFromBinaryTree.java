// 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
//
// 示例 1:
//
//
// 输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
// 输出: "1(2(4))(3)"
//
// 解释: 原本将是“1(2(4)())(3())”，
// 在你省略所有不必要的空括号对之后，
// 它将是“1(2(4))(3)”。
//
//
// 示例 2:
//
//
// 输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \
//      4
//
// 输出: "1(2()(4))(3)"
//
// 解释: 和第一个示例相似，
// 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
//
// Related Topics 树 字符串
// 606. 根据二叉树创建字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.structure.TreeNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ConstructStringFromBinaryTree {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "1(2(4))(3)",
        new Solution()
            .tree2str(DataBuilder.buildTreeNode(DataBuilder.buildIntegerArray("1,2,3,4"))));
    Printer.printCorrectAnswer(
        "1(2()(4))(3)",
        new Solution()
            .tree2str(DataBuilder.buildTreeNode(DataBuilder.buildIntegerArray("1,2,3,null,4"))));
    Printer.printCorrectAnswer(
        "1",
        new Solution().tree2str(DataBuilder.buildTreeNode(DataBuilder.buildIntegerArray("1"))));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 95.12% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 99.14% 的用户
     *
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
      StringBuilder sb = new StringBuilder();
      preOrderTraverse(t, sb);
      int index = sb.lastIndexOf(")");
      return index > 0 ? sb.deleteCharAt(index).toString() : sb.toString();
    }

    private void preOrderTraverse(TreeNode root, StringBuilder sb) {
      if (root != null) {
        if (root.left == null && root.right == null) {
          sb.append(root.val).append(")");
          return;
        }
        sb.append(root.val).append("(");
        if (root.left == null) sb.append(")");
        preOrderTraverse(root.left, sb);
        if (root.right != null) sb.append("(");
        preOrderTraverse(root.right, sb);
        sb.append(")");
      }
    }
  }
}
