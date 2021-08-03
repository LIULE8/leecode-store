// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
//
// 输出：
// [null,null,null,null,-3,null,0,-2]
//
// 解释：
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 155. 最小栈

package com.leo.algorithm.easy.stack;

import java.util.Stack;

public class MinStack {

  private final Stack<Integer> stack;

  /**
   * 执行用时： 352 ms , 在所有 Java 提交中击败了 5.00% 的用户
   *
   * <p>内存消耗： 40.2 MB , 在所有 Java 提交中击败了 37.17% 的用户
   */
  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int val) {
    stack.add(val);
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    int min = 0;
    for (int j = 1; j < stack.size(); j++) {
      if (stack.get(j) < stack.get(min)) {
        min = j;
      }
    }
    return stack.get(min);
  }
}
