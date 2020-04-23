package algos.arrays;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		int nums[] = {0,1,2,3,4,5};
		int ro[]=rotateArray.rotate(nums, 4);
		Arrays.stream(ro).forEach(System.out::println);
	}
	public int[] rotate(int[] nums, int k) {
	       int res[] = new int[nums.length];
	        k=k%nums.length;
	        int i =0; 
	        for ( ; i <nums.length-k;i++){
	          res[i+k]=nums[i];  
	        }
	        for ( int j=0; j <k;j++){
	          res[j]=nums[i++];  
	        }
	        System.arraycopy(res, 0, nums, 0, nums.length);
	        return res;
	    }
}
