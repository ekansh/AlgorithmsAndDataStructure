/*

 *



 *

 *
 




 */
package com.crackingcoding.problem63;

import java.util.Stack;

/**
 * How would you design an integer stack which, in addition to push and pop, also has a function
 * min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ConstantComplexityOrderStack {

  /**
   * Approach based on a inner data structure to store the stack of integers and in the same object
   * the current min value we had when the element was pushed. With this approach we get a time
   * complexity order equals to O(1) but a space complexity order equals to O(N) where N is the
   * number of elements in the stack.
   */
  public static class Stack1 extends Stack<MinValue> {

    public void push(int item) {
      int newMin = Math.min(item, getMin());
      super.push(new MinValue(item, newMin));
    }

    public int getMin() {
      if (isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return peek().minValue;
      }
    }
  }

  static class MinValue {
    final int value;
    final int minValue;

    MinValue(int value, int minValue) {
      this.value = value;
      this.minValue = minValue;
    }
  }

  /**
   * Approach based on keep a parallel data structure with the min elements. Doing this we can
   * reduce the number of additional elements stored, but the complexity order is still O(N) in
   * space terms for the worst case. In time terms, the complexity order is equals to O(1).
   */
  public static class Stack2 extends Stack<Integer> {
    Stack<Integer> innerStack = new Stack<Integer>();

    public void push(int item) {
      if (item <= getMin()) {
        innerStack.push(item);
      }
      super.push(item);
    }

    public Integer pop() {
      int value = super.pop();
      if (value == getMin()) {
        innerStack.pop();
      }
      return value;
    }

    public int getMin() {
      if (innerStack.isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return innerStack.peek();
      }
    }
  }
}
