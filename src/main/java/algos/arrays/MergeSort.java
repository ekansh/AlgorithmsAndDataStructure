package algos.arrays;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
//		int[] nums = new int[] { -1, 8, 2,6,0,3};
		int[] nums = new int[] { -1, 0, 3, 2, 1, 6 };
//		ms.partitionList(nums, 0, nums.length - 1);
//		ms.mergeSortedList(nums, 0, (nums.length-1)/2,nums.length-1);
		ms.mergeSortIter(nums);
		Arrays.stream(nums).forEach(System.out::println);

	}

	// call this with nums, 0, nums.length-1
	public void partitionList(int[] nums, int l, int r) {
		if (l >= r)
			return;
		int mid = l + (r - l) / 2;
		partitionList(nums, l, mid);
		partitionList(nums, mid + 1, r);
		mergeSortedList(nums, l, mid, r);
	}

	// pass indexes
	public void mergeSortedList(int[] nums, int l, int mid, int r) {
		System.out.println(l + "," + mid + "," + r);
		int i = l, j = mid + 1;
		int[] temp = new int[r - l + 1];
		int k = 0;
		while (i <= mid && j <= r) {
			if (nums[i] <= nums[j]) {
				temp[k] = nums[i];
				i++;
			} else if (nums[i] > nums[j]) {
				temp[k] = nums[j];
				j++;
			}
			k++;
		}
		while (i <= mid)
			temp[k++] = nums[i++];
		while (j <= r)
			temp[k++] = nums[j++];

		for (int p = 0; p < temp.length; p++) {
			nums[p + l] = temp[p];
		}
	}

	public void mergeKLists(int[] nums) {

		int interval = 1;
		while (interval < nums.length) {
			System.out.println(nums.length);
			for (int i = 0; i + interval < nums.length; i = i + interval * 2) {
				int left = i, right = i + interval - 1;
				int mid = left + (right - left) / 2;
			}
			interval *= 2;
		}
	}

	public void mergeSortIter(int[] nums) {
		int width;

		for (width = 1; width < nums.length; width = 2 * width) {
			// Combine pairs of array a of width "width"
			int i;

			for (i = 0; i < nums.length; i = i + 2 * width) {
				int left, middle, right;

				left = i;
				middle = i + width;
				right = i + 2 * width;
				System.out.println(String.format("left %d, middle %d, right %d ", left, middle, right));
				mergeSortedList(nums, left, middle, right);

			}
		}
	}
}