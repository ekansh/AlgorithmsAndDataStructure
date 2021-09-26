package algos.strings;

import java.util.*;
import java.util.stream.*;

public class StrWithout3a3b {
	public static String strWithout3a3b(int a, int b) {
		TreeSet<Integer> ts = null;
		int[][] intervals = null;
		Arrays.sort(intervals, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);

		int A = 0, B = 0;
		StringBuilder sb = new StringBuilder();
		while (a > 0 || b > 0) {
			if (a >= b) { // a=3 b =3
				if (A == 2 && b > 0) {
					sb.append('b');
					B++;
					b--;
					A = 0;
				} else {
					sb.append('a');
					A++;
					a--;
				}
			} else if (a < b) {
				if (B == 2 && a > 0) {
					sb.append('a');
					A++;
					a--;
					B = 0;
				} else {
					sb.append('b');
					B++;
					b--;
				}
			}
		}
		return sb.toString();

	}

	public static void main(String[] args) {
//		System.out.println(strWithout3a3b(3, 5));
		StrWithout3a3b sol = new StrWithout3a3b();
		String[] words =new String[] {"What","must","be","acknowledgment","shall","be"};
		
	}

	 
	
}
