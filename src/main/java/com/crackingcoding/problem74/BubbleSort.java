/*

 *



 *

 *
 




 */
package com.crackingcoding.problem74;

import com.crackingcoding.sortingalgorithm.SortingAlgorithm;

/**
 * Given an array full of integers implement a bubble sort algorithm to sort the content inside the
 * array.
 *

 */
public class BubbleSort extends SortingAlgorithm {

  /**
   * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that
   * repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps
   * them if they are in the wrong order. The pass through the list is repeated until no swaps are
   * needed, which indicates that the list is sorted. The algorithm, which is a comparison sort, is
   * named for the way smaller elements "bubble" to the top of the list. Although the algorithm is
   * simple, it is too slow and impractical for most problems even when compared to insertion
   * sort. It can be practical if the input is usually in sort order but may occasionally have
   * some out-of-order elements nearly in position.
   *
   * The complexity order of this algorithm in time terms is O(N^2) where N is equals to the number
   * of elements in the input array. In space terms, the complexity order is O(1) because to solve
   * this problem we are not using any auxiliary data structure.
   */
  public void sort(int[] numbers) {
    validateInput(numbers);

    int length = numbers.length;
    boolean swap = true;
    while (swap) {
      swap = false;
      for (int i = 0; i < length - 1; i++) {
        for (int j = 0; j < length - i - 1; j++) {
          if (numbers[j] > numbers[j + 1]) {
            swap(numbers, j, j + 1);
            swap = true;
          }
        }
      }
    }
  }

}
