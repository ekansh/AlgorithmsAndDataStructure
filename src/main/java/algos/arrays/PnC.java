package algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PnC {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,3,2,4);
		int k = 3;
		combination(nums, 0, 3);
		System.out.println("Combinations");
		print(combos);
		curr.clear();
		permutation(0,nums);
		System.out.println("Permuations");
		print(perms);
	}

	private static void print(List<List<Integer>> op) {
		for (List<Integer> l : op) {// print output
			l.stream().forEach(e -> System.out.print(e + ","));
			System.out.println();
		}
	}

	static List<List<Integer>> combos = new LinkedList<>();
	static LinkedList<Integer> curr = new LinkedList<>();
	static List<List<Integer>> perms = new LinkedList<>();
	public static void combination(List<Integer>  nums, int first, int k) {
		// if the combination is done
		if (curr.size() == k) {
			combos.add(new LinkedList(curr));
			return;
		}
		for (int i = first; i < nums.size(); i++) {
			curr.add(nums.get(i));// add i into the current combination
			combination(nums, i + 1, k);// use next integers to complete the combination
			curr.removeLast();// backtrack
		}
	}

	public static void permutation(int first, List<Integer> l) {
		if (first == l.size()) {
			perms.add(new ArrayList<Integer>(l));
			return;
		}
		for (int i = first; i < l.size(); i++) {
			Collections.swap(l, first, i);
			permutation(first + 1, l); 
			Collections.swap(l, i, first);
		}
	}
}
