package algos.arrays;

public class DuplicateNumber {
public static void main(String[] args) {
	DuplicateNumber d = new DuplicateNumber();
	int[] nums = new int[] { 8,8,2,4,3,5,1,7,6,8};
	System.out.println(nums.length+",");
	int a =d.findRepeat(nums);
	System.out.println(a);
}

	public static int findRepeat(int[] numbers) {

		int floor = 1;
		int ceiling = numbers.length - 1;

		while (floor < ceiling) {

			// divide our range 1..n into an upper range and lower range
			// (such that they don't overlap)
			// lower range is floor..midpoint
			// upper range is midpoint+1..ceiling
			int midpoint = floor + ((ceiling - floor) / 2);
			int lowerRangeFloor = floor;
			int lowerRangeCeiling = midpoint;
			int upperRangeFloor = midpoint + 1;
			int upperRangeCeiling = ceiling;

			// count number of items in lower range
			int itemsInLowerRange = 0;
			for (int item : numbers) {

				// is it in the lower range?
				if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
					itemsInLowerRange += 1;
				}
			}

			int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

			if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

				// there must be a duplicate in the lower range
				// so use the same approach iteratively on that range
				floor = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {

				// there must be a duplicate in the upper range
				// so use the same approach iteratively on that range
				floor = upperRangeFloor;
				ceiling = upperRangeCeiling;
			}
		}

		// floor and ceiling have converged
		// we found a number that repeats!
		return floor;
	}
}
