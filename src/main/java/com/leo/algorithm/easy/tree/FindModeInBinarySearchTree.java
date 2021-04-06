// 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
// 给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树
// 501. 二叉搜索树中的众数

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {
  public static void main(String[] args) {
    new Solution();
  }

  static class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 14.73% 的用户
     *
     * <p>内存消耗： 40.5 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
      depth(root);
      int max = Integer.MIN_VALUE;
      for (Integer key : map.keySet()) {
        max = Math.max(max, map.get(key));
      }
      List<Integer> list = new ArrayList<>();
      for (Integer key : map.keySet()) {
        if (map.get(key) == max) {
          list.add(key);
        }
      }
      int[] res = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }

    private void depth(TreeNode root) {
      if (root != null) {
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        depth(root.left);
        depth(root.right);
      }
    }
  }
}
