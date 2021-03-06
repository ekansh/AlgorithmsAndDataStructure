/*

 *



 *

 *
 




 */
package com.crackingcoding.problem32;

/**
 * Given two strings passed as argument, can you write a method to return true if the second
 * contains the first one?
 *

 */
public class Contains {

  /**
   * Iterative solution to this problem. The complexity order of this algorithm is O(N*M) where N
   * is the length of the first word and M is the length of the second word. In space terms the
   * complexity order of this algorithm is O(1) because we are not using any auxiliary data
   * structure to solve this problem.
   */
  public boolean evaluate(String w1, String w2) {
    if (w1 == null || w2 == null) {
      throw new IllegalArgumentException("You can't pass null strings as input.");
    }
    boolean contains = false;
    for (int i = 0; i < w2.length() - 1; i++) {
      if (w2.charAt(i) == w1.charAt(0)) {
        for (int j = 0; j < w1.length(); j++) {
          if (w1.charAt(j) == w2.charAt(i + j) && j == w1.length() - 1) {
            contains = true;
            break;
          }
        }
      }
    }
    return contains;
  }
}
