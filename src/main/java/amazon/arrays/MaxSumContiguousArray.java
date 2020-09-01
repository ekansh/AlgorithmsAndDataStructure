package amazon.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousArray {
	public static void main(String[] args) {
		int[] nums= new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int max = nums[0];
		int sum =nums[0];
		for ( int i =1; i<nums.length; i++){
			sum = Math.max(nums[i], sum+nums[i]);
			max  = Math.max( sum, max);
		}
		System.out.println(max);
	}
	
}
