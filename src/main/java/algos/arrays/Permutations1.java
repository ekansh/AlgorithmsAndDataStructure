package algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutations1 {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.subsets(new int [] {1,2,3});
				
		Permutations1 permutations = new Permutations1();
		List<Integer> asList = Arrays.asList(1, 2, 3);
		int nums[] = new int[] { 1, 2, 3 };
		List<List<Integer>> permutate = permutations.permute2(nums);
		permutate.add(asList);
	}

	List<List<Integer>> res = new ArrayList<>();
	String orig = "1,2,3";

	public List<List<Integer>> permute2(int[] nums) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			l.add(nums[i]);
		}
		backtrack2(0, l);
		return res;
	}

	public void backtrack2(int pos, List<Integer> l) {
		if (pos == l.size()) {
			System.out.println("added");
			print(l, pos, 0);
			System.out.println("=========");
			res.add(new ArrayList<Integer>(l));
			return;
		}
		for (int i = pos; i < l.size(); i++) {
			Collections.swap(l, pos, i);
			print(l, pos, i);
			backtrack2(pos + 1, l);
			Collections.swap(l, i, pos);
		}
	}

	List<List<Integer>> output = null;

	public void backtrack1(ArrayList<Integer> nums, int first) {
		if (first == nums.size())
			output.add(new ArrayList<Integer>(nums));
		for (int i = first; i < nums.size(); i++) {
			Collections.swap(nums, first, i);
			print(nums, first, i);
			backtrack1(nums, first + 1);
			Collections.swap(nums, first, i);
		}
	}

	private void print(List<Integer> nums, int first, int i) {
		System.out.print("orig " + orig);
		for (int j = 0; j < first; j++)
			System.out.print(" ");
		System.out.print(" pos=" + first + ": i=" + i + "-->");
		nums.stream().forEach(e -> System.out.print("," + e));
		System.out.println();
	}

	public List<List<Integer>> permute1(int[] nums) {
		output = new LinkedList<>();

		ArrayList<Integer> nums_lst = new ArrayList<Integer>();
		for (int num : nums)
			nums_lst.add(num);

		backtrack1(nums_lst, 0);
		return output;
	}
}

class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		output.add(new ArrayList<Integer>());

		for (int num : nums) {
			List<List<Integer>> newSubsets = new ArrayList();
			for (List<Integer> curr : output) {
				newSubsets.add(new ArrayList<Integer>(curr) {
					{
						add(num);
					}
				});
			}
			for (List<Integer> curr : newSubsets) {
				output.add(curr);
			}
Set<int[]>  s = new HashSet<>();
		}
		return output;
	}
}
