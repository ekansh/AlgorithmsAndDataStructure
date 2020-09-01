package backtracking;

import java.util.*;

public class CreatePermutationSelecting1OrMoreAtATime {
	public static void main(String[] args) {
		CreatePermutationSelecting1OrMoreAtATime n = new CreatePermutationSelecting1OrMoreAtATime();
		n.bk(new LinkedList<Integer>(), Arrays.asList(1,2,3), 0,3);
		for (List<Integer> l : n.finalResult) {
			l.stream().forEach(e->System.out.print (e+","));
			System.out.println();
		}
		
	}
	private List<List<Integer>> finalResult = new ArrayList<>();
	public void bk(LinkedList<Integer> res,  List<Integer> numberSet, int pos, int len ) {
		if ( res.size()==len){
			finalResult .add ( new LinkedList<Integer>(res));
			return;
		}
		for ( int i =0; i < numberSet.size(); i++){
			res.add(numberSet.get(i));
			bk( res,numberSet, i,len);
			res.removeLast();
		}
	}
	public String nextClosestTime(String time) {
		int start = 60 * Integer.parseInt(time.substring(0, 2));
		start += Integer.parseInt(time.substring(3));
		int ans = start;
		int elapsed = 24 * 60;
		Set<Integer> allowed = new HashSet();
		for (char c : time.toCharArray())
			if (c != ':') {
				allowed.add(c - '0');
			}

		for (int h1 : allowed)
			for (int h2 : allowed)
				if (h1 * 10 + h2 < 24) {
					for (int m1 : allowed)
						for (int m2 : allowed)
							if (m1 * 10 + m2 < 60) {
								int cur = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
								int candElapsed = Math.floorMod(cur - start, 24 * 60);
								if (0 < candElapsed && candElapsed < elapsed) {
									ans = cur;
									elapsed = candElapsed;
								}
							}
				}

		return String.format("%02d:%02d", ans / 60, ans % 60);
	}
}
