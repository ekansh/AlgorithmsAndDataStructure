package backtracking;

public class PartitionSubset {
	public static void main(String[] args) {
		PartitionSubset ps = new PartitionSubset();
		boolean r =ps.canPartition(new int[] {5,1,11,5});
		System.out.println(r);
	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return fx(nums, 0, 0, sum);
	}
	// Sort and two pointer

	// Brute Force here
	public boolean fx(int[] n, int pos, int cs, int sum) {
		if (cs == sum -cs) {
			return true;
		}
		if (pos == n.length)
			return false;
		boolean res = false;
		for (int i = pos; i < n.length; i++) {
			res |= fx(n, i + 1, cs + n[i], sum);
		}
		return res;
	}
}
