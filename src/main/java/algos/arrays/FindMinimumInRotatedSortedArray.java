package algos.arrays;

public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
		int ar[]={4,5,1,2,3};
		int val = sol.findMin(ar);
		System.out.println(val);
	}
	public int findMin(int[] nums) {
        return findMinIndex(nums,0, nums.length-1);
    }
	
	public int findMinIndex(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		
		if( mid == start  && mid== end ) return mid;
		else if( nums[start] <= nums[end] ) return start;
		else if(nums[mid] <= nums[mid+1] && nums[mid]<=nums[mid-1] ) return mid;
		
		else if ( nums[start] > nums[end]) {
			if(nums[mid]<=nums[start] && nums[mid] <= nums[end]) return findMinIndex(nums,0, mid -1);
			else if(nums[mid]>=nums[start] && nums[mid] >= nums[end]) return findMinIndex(nums,mid+1, end);
		}
		
	
		return -1;
	}
}

/*
 * 4 1 2 3 4 0 1 2 3

class Solution {
public int findMin(int[] nums) {
    return findMinIndex(nums,0, nums.length-1);
}

public int findMinIndex(int[] nums, int start, int end) {
	int mid = (start + end) / 2;
	if (mid - 1 <= 0)
		return nums[mid] < nums[mid + 1] ? mid : mid + 1; // something
	if (mid + 1 >= nums.length)
		return nums[mid]; // this case shouldnt happen
	if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
		return mid;
	} else if (nums[start] > nums[end]// array is still rotated
			&& nums[mid] <= nums[start] && nums[mid] <= nums[end]) { // since array is rotated , right will be increasing
		// so go left
		return findMinIndex(nums, 0, mid - 1);
	} else if (nums[start] > nums[end]// array is still rotated
			&& nums[mid] >= nums[start] && nums[mid] >= nums[end]) { // since array is rotated , left will be increasing
		// so go right
		return findMinIndex(nums, mid + 1, end);
	}else if (nums[start] < nums[end]) {// array is not rotated and is all sorted
			//the very first element is the solution ;
		return start;
	}
	
	return -2;
}
}
/*
0 1  2 3 4 5 6 7 8 9 11 12 13
11 12 13  0 1  2 3 4 5 6 7 8 9 10
4  1 2 3
4 0 1 2 3
*/