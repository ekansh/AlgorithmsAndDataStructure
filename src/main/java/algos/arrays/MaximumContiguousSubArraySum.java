package algos.arrays;

import java.util.*;

public class MaximumContiguousSubArraySum {
	public static void main(String[] args) {
		MaximumContiguousSubArraySum m = new MaximumContiguousSubArraySum();
		List<Integer> asList = Arrays.asList(-2,1,6,2,-3,5);
		int k1 =m.maximumContiguousSubArraySum(asList,5);
		int k2 =m.maximumContiguousSubArraySumBruteForce(asList,5);
		System.out.println(k1+":"+k2);
	} 
	private int maximumContiguousSubArraySum(List<Integer> list, int k) {
		int rSum =0,sum=0;
		for ( int i =0; i<list.size(); i++) {
//			rSum=Math.max(list.get(i),list.get(i)+rSum);
			if( list.get(i)+rSum >=list.get(i)) { // overflow
				rSum =rSum +list.get(i);
			}else {
				rSum =list.get(i);
			}
			sum = Math.max(rSum, sum);
		}
		return sum;
	}
	
	private int maximumContiguousSubArraySumBruteForce(List<Integer> list, int k) {
		int sum =list.get(0),t_sum=0;
		for ( int i =0; i<list.size(); i++) {
			t_sum=0;
			for ( int g =i; g<list.size(); g++) {
				 t_sum = t_sum+list.get(g);
				sum =Math.max(sum, t_sum);
			}
		}
		return sum;
	}
}
