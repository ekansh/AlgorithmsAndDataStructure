package algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		List<Integer> asList = Arrays.asList(1, 2,3);
		List<List<Integer>> permutate = permutations.permutate(asList);
		permutate.add(asList);
//		for (List<Integer> l:permutate) {
//			l.stream().forEach(e-> System.out.print(e+","));
//			System.out.println();
//		}
	}

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> permutate(List<Integer> l) {
		permutateUsingFor(l,0);
		return res;
	}

	public void permutateUsingRecur(List<Integer> l, int first, int sec) {
		if (first == l.size() || sec == l.size()) {
			return;
		}
		print(l, first, sec);
		swap(l, first, sec);
		permutateUsingRecur(l, first + 1,sec);
		permutateUsingRecur(l, first ,sec+1);
		swap(l,sec,first);

	}

	public void permutateUsingFor(List<Integer> l, int first) {
		if (first == l.size()) {
			return;
		}
		for (int i = first; i < l.size(); i++) {
			print(l, first, i);
			swap(l, first, i);
			permutateUsingFor(l, first + 1);
			swap(l, i, first);
		}
	}

	private void swap(List<Integer> l, int first, int i) {
//		if( i>=0)return;
		if (i == first)
			return;
		int temp = l.get(i);
		l.set(i, l.get(first));
		l.set(first, temp);
	}

	private void print(List<Integer> l, int first, int i) {
		String c = l.stream().map(e -> "" + e).collect(Collectors.joining(","));
		String sp = "";
		for (int j = 0; j < first; j++)
			sp += " ";
		System.out.println("[" + sp + c + ",f:" + first + ",i:" + i + "]");
	}

	private void swapAndAdd(List<Integer> l, int first, int i) {
		if (i == first)
			return;
		List<Integer> l1 = new ArrayList<>(l);
		int temp = l1.get(i);
		l1.set(i, l1.get(first));
		l1.set(first, temp);
		res.add(l1);

	}

	public void permutate(List<Integer> l, int first) {
		if (first == l.size()) {
			return;
		}
		for (int i = first; i < l.size(); i++) {
			print(l, first, i);
			swapAndAdd(l, first, i);
			permutate(l, first + 1);
		}
	}

}
