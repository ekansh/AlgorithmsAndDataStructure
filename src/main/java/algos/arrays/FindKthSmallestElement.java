package algos.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * It is not a very good implementation . if k is very small than n then it
 * makes sense to find k small element and then sort only the k element .
 * Otherwise just sort the array list
 * 
 * @author Ekansh
 *
 */
public class FindKthSmallestElement {
	Integer max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int kthSmallest = new FindKthSmallestElement().kthSmallest();
		System.out.println(kthSmallest);
	}

	private int kthSmallest() {
		int k = 3;
		List<Integer> asList = Arrays.asList(11, 2, 3, 5, 2, 9, 8, 3, 1, 14, 5);
		Set<Integer> minSet = new HashSet<Integer>();
		for (Integer integer : asList) {
			storeMin(integer, minSet, k);
		}
		if (minSet.size() < k)
			return -1;
		Optional<Integer> findFirst = minSet.stream().sorted((a, b) -> b - a).limit(1).findFirst();
		return findFirst.get(); // not sorted
	}

	public void storeMin(Integer val, Set<Integer> minSet, int k) {
		if (val == null) {
			return;
		} else if (minSet.size() < k) {
			minSet.add(val);
			max = Math.max(max, val);
			min = Math.min(min, val);
		} else if (val < max) {
			minSet.remove(max);
			minSet.add(val);
			max = Integer.MIN_VALUE;
			;
			minSet.stream().forEach(e -> max = Math.max(max, e));
		}
	}
}
