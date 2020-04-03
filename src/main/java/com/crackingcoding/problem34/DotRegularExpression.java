/*

 *



 *

 *
 




 */
package com.crackingcoding.problem34;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings, can you write a method to return return just words that matches with
 * a pattern containing the "." regular expression.
 *

 */
public class DotRegularExpression {

  /**
   * Iterative and recursive solution to solve this problem. The complexity order of this algorithm
   * is O(N*M) where N is the number of elements in the input array and M the complexity order of
   * the method written below. In space terms the complexity order of this algorithm is O(N) because
   * we are using an array to keep the result of the problem.
   */
  public String[] evaluate(String[] words, String pattern) {
    if (words == null || pattern == null) {
      throw new IllegalArgumentException("You can't pass null objects as input.");
    }
    List<String> result = new ArrayList<String>();
    for (String word : words) {
      if (matchDotRegularExpression(word, pattern)) {
        result.add(word);
      }
    }
    return result.toArray(new String[result.size()]);
  }

  /**
   * The complexity order of this recursive algorithm is O(N) where N is the number of letters in
   * the word.
   */
  private static boolean matchDotRegularExpression(String word, String pattern) {
    if (Math.abs(word.length() - pattern.length()) > 1) {
      return false;
    } else if (word.isEmpty() && pattern.isEmpty()) {
      return true;
    } else if (pattern.charAt(0) == '.') {
      return matchDotRegularExpression(word.substring(1), pattern.substring(1));
    } else {
      boolean partialMatch = word.charAt(0) == pattern.charAt(0);
      return partialMatch && matchDotRegularExpression(word.substring(1), pattern.substring(1));
    }
  }
}
