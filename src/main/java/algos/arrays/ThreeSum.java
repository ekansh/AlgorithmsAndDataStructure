package algos.arrays;

class ThreeSum {
	public static void main(String[] args) {
		int firstBadVersion = new ThreeSum().firstBadVersion(3);
		System.out.println(firstBadVersion);
	}

	int min = Integer.MAX_VALUE;

	public int firstBadVersion(int l, int r) { // [1,2]
		if (l > r)
			return min;
		int mid = l + (r - l) / 2;
		if (isBadVersion(mid)) {
			min = mid;
			int t = firstBadVersion(l, mid - 1);
			min = Math.min(t, min);
		} else {
			int t = firstBadVersion(mid + 1, r);
			min = Math.min(t, min);
		}
		return min;

	}

	private boolean isBadVersion(int mid) {
		return mid >= 2 ? true : false;
	}

	public int firstBadVersion1(int n) { // [1]
		return firstBadVersion(1, n);
	}

	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid ;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}