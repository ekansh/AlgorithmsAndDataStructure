package algos.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShiftArray {
	public static void main(String[] args) {

	}

	public void moveZeroes(int[] nums) {
		int length = nums.length;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				shiftArrayLeftBy1(nums, i);
				length--;
			}
		}
		for (int i = nums.length - 1; i >= length; i--) {
			nums[i] = 0;
		}
	}

	/**
	 * ,
	 * 
	 * @param n=1 2 3 4 5 6 7
	 * @param startPos=2 (index) n=1,2,4,5,6,7,7
	 */
	public void shiftArrayLeftBy1(int[] n, int startPos) {
		for (int i = startPos; i + 1 < n.length; i++) {
			n[i] = n[i + 1];
		}
	}

	/**
	 * ,
	 * 
	 * @param n=1 2 3 4 5 6 7
	 * @param startPos=2 (index) n=1,2,3,3,4,5,6,
	 */
	public void shiftArrayRightBy1(int[] n, int startPos) {
		for (int i = n.length - 1; i - 1 >= startPos; i--) {
			n[i] = n[i - 1];
		}
	}

}

class MyQ {
	Integer f;
	Integer r;
	Integer n[];
	Integer size;

	MyQ(int s) {
		this.size=s;
		f=0;
		r=-1;
		n = new Integer[s];
	}
	public boolean add(Integer e) {
		if(getSize() ==size) {
			return false;
		}else {
			r=(r+1)%size;
			n[r]=e;
			return true;
		}
	}
	
	private Integer getSize() {
		if(r>=f) {
			return r-f+1;
		}else {
			return size-f+r+1;
			
		}
		
		
	}
	public Integer poll() {
		if(getSize() ==0) {
			return null;
		}else {
			f=(f+1)%size;
			return n[f];
		}
	}
}
