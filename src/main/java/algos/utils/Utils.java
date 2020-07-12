package algos.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {
	public static void main(String[] args) {
		char [] c= {'a','c','b'};
		 Utils u = new Utils();
		List<String> d =u.convertToStrList(c);
		u.printArrayString(d);
		char[] convertToCharArray = u.convertToCharArray(d);
		u.printCharArray(convertToCharArray);
	}

	public List<Integer> convertToIntList(int a[]) {
		List<Integer> l1 = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			l1.add(a[i]);
		}
		return l1;
	}

	public List<String> convertToStrList(char a[]) {
		List<String> l1 = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			l1.add("" + a[i]);
		}
		return l1;
	}

	public int[] convertToIntArray(List<Integer> a) {
		int r[] = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != null) {
				r[i] = a.get(i);
			}
		}
		return r;
	}

	public char[] convertToCharArray(List<String> a) {
		char r[] = new char[a.size()];
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != null) {
				r[i] = a.get(i).charAt(0);
			}
		}
		return r;
	}

	public void printArrayString(Collection<String> t) {
		t.stream().forEach(e -> System.out.print(e + ","));
		System.out.println();
	}

	public void printArrayInteger(Collection<Integer> t) {
		t.stream().forEach(e -> System.out.print(e + ","));
		System.out.println();
	}
	///// ARRAY
	public void printCharArray(char [] t) {
		for ( int i =0;i<t.length;i++) {
			System.out.print(t[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
	public void printIntArray(int [] t) {
		for ( int i =0;i<t.length;i++) {
			System.out.print(t[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
}
