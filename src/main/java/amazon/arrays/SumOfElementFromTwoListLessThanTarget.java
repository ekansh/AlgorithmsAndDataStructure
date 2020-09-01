package amazon.arrays;

import java.util.*;

// sum of Elements from two list whose sum <=target
// Optimal Utilization solution
public class SumOfElementFromTwoListLessThanTarget {
	public static void main(String[] args) {
		SumOfElementFromTwoListLessThanTarget s = new SumOfElementFromTwoListLessThanTarget();
		int[] a1 = new int[] {1,3,3,7,7}; // foreground process 
		int[] b1 = new int[] { 0,1,2,2,4,4};  // background process
		s.process(a1, b1, 9);
		System.out.println();
	}
 


	private Set<List<Integer>> getPairs(List<int[]> a, List<int[]> b, int target) {
		Collections.sort(a, (i, j) -> i[1] - j[1]);
		Collections.sort(b, (i, j) -> i[1] - j[1]);
		Set<List<Integer>> result = new LinkedHashSet<>();
		int max = Integer.MIN_VALUE;
		max = getBestSingleProcessSize(a,max,target,result,1);
		max = Math.max(getBestSingleProcessSize(b,max,target,result,2),max);
		int m = a.size() , n = b.size(), i = 0,j = n - 1;
		while (i < m && j >= 0) {
			int sum = a.get(i)[1] + b.get(j)[1];
			if (sum > target) {
				--j;
			} else { // sum <=target
				if (sum > max) { // sum >max ..we found new candidate
					max = sum;
					result.clear();
				}
				if (sum == max) {
					List<Integer> l =new ArrayList<Integer>();
					l.add(a.get(i)[0]);l.add(b.get(j)[0]);
					result.add(l);// insert the candidate
					// handle dups 
					int sa=i, eb =j;
					while ( i+1<m  && a.get(i)[1] ==a.get(i+1)[1])
						i++;
					while ( j-1>=0  && b.get(j)[1] ==b.get(j-1)[1]) 
						j--;
					getAllCombinations(a,b,sa,i,j,eb,result);
				} 
				// sum less than target and less than max then increment i;
				// also increment i if sum == max ( where max <=target)
				//in case incrementing i over shoots,.. we will do j--
				i++;
			}
		}
		for (List<Integer> js : result) {
			System.out.println(js.get(0) + ":" + js.get(1));
		}
		return result;
	}
 

	private int getBestSingleProcessSize(List<int[]> a, int max, int target,Set<List<Integer>> result, int id ) {
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i)[1]>target) break;
			else {
				if( a.get(i)[1]>max) {
					max =a.get(i)[1];
					result.clear();
				}
				if( max  == a.get(i)[1]) {
					List<Integer> l =new ArrayList<Integer>();
					if( id ==1 ) {l.add(a.get(i)[0]);l.add(-1);};
					if( id ==2 ) {l.add(-1);l.add(a.get(i)[0]); };
					result.add(l);
				}
			}
		}
		return max;
	}
	private void  getAllCombinations(List<int[]> a, List<int[]> b, int sa,int ea, int sb,  int eb,Set<List<Integer>> op) {
		if( sb == eb && ea ==sa) return ;
		for ( int i =sb; i<=eb; i++) {
			for ( int j =sa; j<=ea; j++) {
				List<Integer> l =new ArrayList<Integer>();
				l.add(a.get(j)[0]);
				l.add(b.get(i)[0]);
				op.add(l);
			}
		}
	}
	public List<List<Integer>> process(int[] a1, int[] b1, int K) {
		List<int[]> a = new ArrayList<int[]>();
		List<int[]> b = new ArrayList<int[]>();
		for (int i = 0; i < a1.length; i++) {
			a.add(new int[] { i, a1[i] });
		}
		for (int i = 0; i < b1.length; i++) {
			b.add(new int[] { i, b1[i] });
		}
		getPairs(a, b, K);
		return null;
	}
}