package binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class RandomWeightLoadBalancer {
	public static void main(String[] args) {
		RandomWeightLoadBalancer s = new RandomWeightLoadBalancer();
//		long maxTaxiEarnings =s.maxTaxiEarnings(10,
//				new int[][]  {{2,3,6},{8,9,8},{5,9,7},{8,9,1},{2,9,2},{9,10,6},{7,10,10}} );
//		
		for ( int i =1;i<=28;i++) {
			System.out.println(i+"::"+s.randomWeight(new int[] {2,3,5,7},i));
		}
		
	}
	
	
	public int randomWeight(int wt[], int k ) {// 2 3 5 7 10; 5
		int[] spaces = new int [wt.length+1];
		for ( int i =0; i<wt.length;i++) {
			spaces[i+1]=spaces[i]+wt[i];
		}// 0 2 5 10 17 27 ;6
		int l =0, r = spaces.length-1;
		Random ra = new Random();
		int random = ra.nextInt(spaces[spaces.length-1]); // 1/2/27/26/10/11/9
		random = k;
		while ( l+1<r) {
			int mid = l+(r-l)/2;
			if ( random>spaces[mid]) {
				l=mid;
			}else if ( random <=spaces[mid]) {
				r= mid;
			}
		}
		
		// 2 3 5 
		return wt[l];
	}
	
	
}
