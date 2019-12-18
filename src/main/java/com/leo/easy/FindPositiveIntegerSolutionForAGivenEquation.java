package com.leo.easy;

import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1237. 找出给定方程的正整数解
 *
 * <p>给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。
 *
 * <p>给定函数是严格单调的，也就是说：
 *
 * <p>f(x, y) < f(x + 1, y) f(x, y) < f(x, y + 1) 函数接口定义如下：
 *
 * <p>interface CustomFunction { public:   // Returns positive integer f(x, y) for any given
 * positive integer x and y.   int f(int x, int y); };
 * 如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。
 *
 * <p>你可以将满足条件的 结果数对 按任意顺序返回。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：function_id = 1, z = 5 输出：[[1,4],[2,3],[3,2],[4,1]] 解释：function_id = 1 表示 f(x, y) = x + y
 * 示例 2：
 *
 * <p>输入：function_id = 2, z = 5 输出：[[1,5],[5,1]] 解释：function_id = 2 表示 f(x, y) = x * y
 *
 * <p>提示：
 *
 * <p>1 <= function_id <= 9 1 <= z <= 100 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。 在 1 <= x, y
 * <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPositiveIntegerSolutionForAGivenEquation {
  public static void main(String[] args) {
    List<List<Integer>> solution = new Solution().findSolution(new CustomFunction(), 5);
    Printer.printDoubleList(solution);
  }

  static class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
      //            return x + y;
      return x * y;
    }
  };

  static class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
      //      return method1(customfunction, z);
      return method2(customfunction, z);
    }

    private List<List<Integer>> method2(CustomFunction customfunction, int z) {
      List<List<Integer>> res = new ArrayList<>();
      int l = 1;
      int r = 1000;
      while (l <= 1000 && r >= 1) {
        int temp = customfunction.f(l, r);
        if (temp == z) {
          List<Integer> list = new ArrayList<>();
          list.add(l);
          list.add(r);
          res.add(list);
          l++;
        } else if (temp > z) {
          r--;
        } else {
          l++;
        }
      }
      return res;
    }

    private List<List<Integer>> method1(CustomFunction customfunction, int z) {
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 1; i <= z; i++) {
        for (int j = 1; j <= z; j++) {
          if (customfunction.f(i, j) == z) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(j);
            result.add(list);
            break;
          }
        }
      }
      return result;
    }
  }
}
