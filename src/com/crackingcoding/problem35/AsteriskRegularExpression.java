/*

 *



 *

 *
 




 */
package com.crackingcoding.problem35;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of strings, can you write a method to return return just words that matches with
 * a pattern containing the "*" regular expression.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class AsteriskRegularExpression {

  /**
   * Combination of iterative and recursive approaches to resolve this problem. The complexity
   * order in time terms is O(N*M) where N is the number of elements in the input array and M the
   * size of the word in the array. In space terms, the complexity order of this algorithm is O(N)
   * because we are using an additional data structure to store the result.
   */
  public String[] evaluate(String[] words, String pattern) {
    if (words == null || pattern == null) {
      throw new IllegalArgumentException("You can't use null instances as input.");
    }

    List<String> result = new LinkedList<String>();
    for (String word : words) {
      if (matchAsteriskRegularExpression(word, pattern)) {
        result.add(word);
      }
    }
    return result.toArray(new String[result.size()]);
  }

  /**
   * The complexity order of this algorithm is more than O(N) but I don't know how to calculate it
   * using this recursive version. Is O(N) approximately.
   */
  private static boolean matchAsteriskRegularExpression(String word, String pattern) {
    if (word.isEmpty() && pattern.isEmpty()) {
      return true;
    } else if (word.isEmpty() || pattern.isEmpty()) {
      return false;
    } else if (pattern.charAt(0) == '*') {
      boolean matchRestOfWord = matchAsteriskRegularExpression(word.substring(1), pattern);
      boolean matchRestOfPattern = matchAsteriskRegularExpression(word, pattern.substring(1));
      return matchRestOfWord || matchRestOfPattern;
    } else {
      boolean partialMatch = word.charAt(0) == pattern.charAt(0);
      return partialMatch && matchAsteriskRegularExpression(word.substring(1),
          pattern.substring(1));
    }
  }
}
