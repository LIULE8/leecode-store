// 给定一个 N 叉树，返回其节点值的 后序遍历 。
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
//
//
//
//
//
// 进阶：
//
// 递归法很简单，你可以使用迭代法完成此题吗?
//
//
//
// 示例 1：
//
//
//
//
// 输入：root = [1,null,3,2,4,null,5,6]
// 输出：[5,6,3,2,4,1]
//
//
// 示例 2：
//
//
//
//
// 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
// null,13,null,null,14]
// 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
//
//
//
//
// 提示：
//
//
// N 叉树的高度小于或等于 1000
// 节点总数在范围 [0, 10^4] 内
//
//
//
// Related Topics 树
// 590. N 叉树的后序遍历

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePostorderTraversal {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public List<Integer> postorder(Node root) {
      //      return method1(root);
      return method2(root);
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 42.03% 的用户
     *
     * <p>内存消耗： 39.4 MB , 在所有 Java 提交中击败了 36.86% 的用户
     *
     * @param root
     * @return
     */
    private List<Integer> method2(Node root) {
      LinkedList<Integer> list = new LinkedList<>();
      if (root == null) return list;
      Stack<Node> stack = new Stack<>();
      stack.add(root);
      while (!stack.isEmpty()) {
        Node pop = stack.pop();
        list.addFirst(pop.val);
        if (pop.children != null) {
          stack.addAll(pop.children);
        }
      }
      return list;
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 39.79% 的用户
     *
     * <p>内存消耗： 39.4 MB , 在所有 Java 提交中击败了 34.07% 的用户
     *
     * @param root
     * @return
     */
    private List<Integer> method1(Node root) {
      List<Integer> list = new LinkedList<>();
      if (root == null) return list;
      if (root.children != null) {
        for (Node child : root.children) {
          list.addAll(postorder(child));
        }
      }
      list.add(root.val);
      return list;
    }
  }
}
