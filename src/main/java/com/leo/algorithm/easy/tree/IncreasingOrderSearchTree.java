// 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
//
//
//
// 示例 ：
//
// 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
//  /        / \
// 1        7   9
//
// 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//   \
//    2
//     \
//      3
//       \
//        4
//         \
//          5
//           \
//            6
//             \
//              7
//               \
//                8
//                 \
//                 9
//
//
//
// 提示：
//
//
// 给定树中的结点数介于 1 和 100 之间。
// 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
//
// Related Topics 树 深度优先搜索 递归
// 897. 递增顺序查找树

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public TreeNode increasingBST(TreeNode root) {
      //      return method1(root);
      return method2(root);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 42.83% 的用户
     */
    TreeNode cur;

    private TreeNode method2(TreeNode root) {
      TreeNode newRoot = new TreeNode(0);
      cur = newRoot;
      searchBST(root);
      return newRoot.right;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 5.10% 的用户
     *
     * @param root
     * @return
     */
    private TreeNode method1(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      searchBST(root, list);
      TreeNode newRoot = new TreeNode(0), cur = newRoot;
      for (Integer num : list) {
        cur.right = new TreeNode(num);
        cur = cur.right;
      }
      return newRoot.right;
    }

    private void searchBST(TreeNode root, List<Integer> list) {
      if (root == null) return;
      searchBST(root.left, list);
      list.add(root.val);
      searchBST(root.right, list);
    }

    private void searchBST(TreeNode root) {
      if (root == null) return;
      searchBST(root.left);
      root.left = null;
      cur.right = root;
      cur = cur.right;
      searchBST(root.right);
    }
  }
}
