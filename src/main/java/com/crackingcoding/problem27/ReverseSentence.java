/*

 *



 *

 *
 




 */
package com.crackingcoding.problem27;

/**
 * Given an input String containing a sentence, can you write a method to reverse the content of
 * the sentence without reverse every word?
 *
 * For example:
 *
 * Input: "Pedro Vicente Gómez" Output: "Gómez Vicente Pedro"
 *

 */
public class ReverseSentence {

  private static final String WORD_SEPARATOR = " ";

  /**
   * Iterative solution for this problem. The complexity order of this algorithm is equals to O(N)
   * where N is the number of chars in the sentence because split method is really expensive. In
   * space terms the complexity order is also O(N) because we are using one StringBuilder to store
   * the result of the algorithm.
   */
  public String reverse(String sentence) {
    if (sentence == null) {
      throw new IllegalArgumentException("Input param can't be null.");
    }
    StringBuilder stringBuilder = new StringBuilder();
    String[] words = sentence.split(WORD_SEPARATOR);
    for (int i = words.length - 1; i >= 0; i--) {
      stringBuilder.append(words[i]);
      if (i != 0) {
        stringBuilder.append(" ");
      }
    }
    return stringBuilder.toString();
  }
}
