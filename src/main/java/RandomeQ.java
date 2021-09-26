
import java.util.*;

import dataStructure.TreeNode;

public class RandomeQ {

	static LinkedList<Integer> ll = new LinkedList<>();
	static List<Integer> l1 = new LinkedList<>();

	static int max = 0;

	/*
	 * BWBB i=1, j =1, k= 1
	 */
	public static boolean checkPattern(char[] arr, int[] pat) {
		int c = 0;
		for (int i = 0; i < arr.length && c < pat.length; i++) {
			if (arr[i] == 'B') {
				int j = i;
				int k = pat[c];
				while (j < arr.length && arr[j] == 'B' && k > 0) {
					j++;
					k--;
				}
				if (k == 0 && (j == arr.length || arr[j] == 'W')) {
					c++;
				} else {
					if (k == 0) {
						while (j < arr.length && arr[j] == 'B') {
							j++;
						}
					}
				}
				i = j - 1;
			}
		}
		return c == pat.length;
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		if (text1.length() < text2.length())
			return longestCommonSubsequence(text2, text1);
		int k = 0, p1 = 0, p2 = 0, cur = 0;
		for (p1 = 0; p1 < text1.length(); p1++) {
			cur = 0;
			p2 = 0;
			String a = "";
			for (int i = p1; i < text1.length(); i++) {
				int j = p2;
				for (; j < text2.length(); j++) {
					if (text1.charAt(i) == text2.charAt(j)) {
						a = a + text1.charAt(i);
						cur++;
						p2 = j + 1;
						break;
					}
				}
				if (p2 == text2.length()) {
					break;
				}
			}
			k = Math.max(cur, k);
			System.out.println(a);
		}
		return k;
	}

	static int mat[][] = null;

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();
		if (nums.length == 0) {
			if (lower == upper)
				res.add(lower + "");
			else
				res.add(lower + "->" + upper);
			return res;
		}

		int l = lower, diff = 0, u = nums[0];
		String s = "->";
		diff = (u) - l;
		// u = -x+1, l = -x
		if (diff == 1) {
			res.add(l + "");
		} else if (diff > 1) {
			res.add(l + s + (u - 1));
		}

		l = nums[0];
		for (int i = 1; i < nums.length - 1; i++) {
			u = nums[i];
			diff = (u - 1) - l;
			if (diff == 1) {
				res.add(l + "");
			} else if (diff > 1) {
				res.add((l + 1) + s + (u - 1));
			}
			l = nums[i];
		}

		l = nums[nums.length - 1];
		u = upper;
		diff = u - l;
		if (diff == 1) {
			res.add(u + "");
		} else if (diff > 1) {
			res.add((l + 1) + s + upper);
		}
		return res;
	}

	public static int longestCommonSubsequence1(String text1, String text2) {
		mat = new int[text1.length()][text2.length()];
		for (int i = 0; i < mat.length; i++) {
			Arrays.fill(mat[i], -1);
		}
		return lcs(text1, 0, text2, 0);
	}

	public static int lcs(String t1, int i1, String t2, int i2) {
		if (t1.length() == i1 || t2.length() == i2) {
			// System.out.println("--");
			return 0;
		}
		if (mat[i1][i2] != -1) {
			// System.out.println("==");
			return mat[i1][i2];
		}
		int val = 0;
		if (t1.charAt(i1) == t2.charAt(i2)) {
			System.out.print(t1.charAt(i1));
			val = 1 + lcs(t1, i1 + 1, t2, i2 + 1);
			System.out.println("--");
		} else
			val = Math.max(lcs(t1, i1 + 1, t2, i2), lcs(t1, i1, t2, i2 + 1));
		mat[i1][i2] = val;
		return val;
	}

	static boolean first_found = false;
	static int last = 0;
	static int start = 0;

	// p1 text1 , p2 text2
	public static void longestCommonSubsequence(String text1, String text2, int p1, int p2) {
		if (p2 == text2.length()) {
			last = Math.max(p1, last);
			return;
		}

		for (int i = p1; i < text1.length(); i++) {
			if (text1.charAt(i) == text2.charAt(p2)) {
				if (!first_found) {
					start = i;
					first_found = true;
				}
				longestCommonSubsequence(text1, text2, i + 1, p2 + 1);
			}
			if (first_found && p1 == 0)
				break;
		}
		return;
	}

	public static int lengthOfLIS(int[] nums) {
		return lengthOfLIS(nums, 0, 0, 0);
	}

	public static int lengthOfLIS1(int[] nums, int pos, int prev) {
		int max = 0, taken = 0, not_taken = 0;
		if (pos == nums.length || prev == nums.length) {
			return 0;
		}

		if (pos != prev && nums[pos] > nums[prev]) {
			taken = 1 + lengthOfLIS1(nums, pos + 1, pos);
		}

		not_taken = lengthOfLIS1(nums, pos + 1, prev);
		max = Math.max(max, Math.max(not_taken, taken));

		return max;
	}

	private static int lengthOfLIS(int[] nums, int prev, int pos, int stack) {
		int val = 0;
		if (pos == nums.length) {
			return 0;
		}
		print(nums, prev, pos, stack);
		for (int i = pos; i < nums.length; i++) {
			if (nums[i] > prev) {
				int temp = 1 + lengthOfLIS(nums, nums[i], i + 1, stack + 1);
				val = Math.max(temp, val);
			}
		}
		return val;
	}

	private static void print(int[] nums, int prev, int pos, int stack) {
		System.out.print(stack);
		for (int i = 0; i < stack; i++) {
			System.out.print(" ");
		}
		System.out.println(":" + prev + "----" + nums[pos] + "");
	}

	public String removeKdigits(String num, int k) {
		Stack<Character> st = new Stack<>();
		int i = 0;
		for (; i < num.length() && k > 0; i++) {
			if (st.isEmpty() || st.peek() <= num.charAt(i)) {
				st.push(num.charAt(i));
			} else if (!st.isEmpty()) { // implies opposite of above.. if st.isEmpty() == false or ! st.isEmpty()
				// st.peek() <=num.charAt(i) must have been false too for the above block not to
				// execute
				while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
					st.pop();
					k--;
				}
				st.push(num.charAt(i));
			}

		}
		for (; i < num.length(); i++) {
			st.push(num.charAt(i));
		}

		// if there are still some elements in the stack and k >0 then they all must be
		// increasing
		while (k > 0 && !st.isEmpty()) {
			st.pop();
			k--;
		}
		StringBuilder sb = new StringBuilder();
		boolean prefix = true;
		for (int p = 0; p < st.size(); p++) {
			if (prefix && st.get(p) == '0')
				continue;
			else {
				prefix = false;
				sb.append(st.get(p));
			}
		}
		return num;

	}

	public static int wiggleMaxLength(int[] nums) {
		if (nums.length < 3)
			return 0;
		return wiggleMaxLength(nums, 2, (nums[0] - nums[1]));
	}

	public static int wiggleMaxLength(int[] nums, int pos, int prev_diff) {
		if (pos >= nums.length - 1)
			return 0;

		int cur = 0, max = 0, prev_pos = pos - 1;
		int diff = nums[prev_pos] - nums[pos];

		for (int i = pos; i < nums.length; i++) {

			// 1,7,4,9,2,5]
			// prev_pos =2, i =3, pd =+ , diff -, cur =4
			diff = nums[prev_pos] - nums[i];
			if ((diff < 0 && prev_diff > 0) || (diff > 0 && prev_diff < 0)) {
				cur = cur == 0 ? 3 : cur + 1;
				System.out.println(prev_pos + ":" + i + ", " + cur);
				prev_pos = i;
				prev_diff = diff;
			}

		}
		System.out.println();
		return cur;
	}

	public static int candy(int[] ratings) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int dp[] = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			pq.add(new int[] { ratings[i], i });

		}
		int sum = 0;// { 1, 2, 2 }));
		while (!pq.isEmpty()) {
			boolean left_eq = false, right_eq = false;
			int left = 0, right = 0;
			int[] ele = pq.poll();
			// if rating on left and right are lower are not same ... then new_rating = max
			// +1;

			if (ele[1] - 1 >= 0) {
				if (dp[ele[1] - 1] > 0) {
					if (ratings[ele[1] - 1] < ratings[ele[1]]) {
						left = dp[ele[1] - 1];
					} else if (ratings[ele[1] - 1] == ratings[ele[1]]) {
						left_eq = true;
						left = dp[ele[1] - 1];
					}
					Deque<Integer> dq = new LinkedList<>();
				}
			}

			if (ele[1] + 1 < ratings.length) {
				if (dp[ele[1] + 1] > 0) {
					if (ratings[ele[1] + 1] < ratings[ele[1]]) {
						right = dp[ele[1] + 1];
					} else if (ratings[ele[1] + 1] == ratings[ele[1]]) {
						right_eq = true;
						right = dp[ele[1] + 1];
					}
				}
			}
			int rating = Math.max(left, right);
			if (left_eq || right_eq) {
				dp[ele[1]] = rating;
			} else {
				dp[ele[1]] = rating + 1;
			}

			sum = sum + dp[ele[1]];
		}
		return sum;
	}

	public static int minJumps(int[] arr) {
		Set<Integer> seen = new HashSet<>();
		Deque<Integer> dq = new LinkedList<>();

		Queue<Integer> q = new LinkedList<>();
		int step = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> l1 = map.getOrDefault(arr[i], new ArrayList<>());
			l1.add(i);
			map.putIfAbsent(arr[i], l1);
		}
		q.add(0);

		while (!q.isEmpty()) {
			int b = q.size();
			for (int i = 0; i < b; i++) {
				int index = q.poll();
				if (index == arr.length - 1)
					return step;
				if (seen.contains(index))
					continue;
				seen.add(index);
				if (!seen.contains(index - 1) && index - 1 >= 0)
					q.add(index - 1);
				if (!seen.contains(index + 1) && index + 1 < arr.length)
					q.add(index + 1);
				if (map.containsKey(arr[index])) {
					map.get(arr[index]).stream().filter(ind -> !seen.contains(ind)).forEach(e -> q.add(e));
					map.remove(arr[index]);
				}
			}
			step++;
		}
		return -1;
	}

	static int min = 100000;
	static Map<Integer, Integer> memo = new HashMap<>();

	public static void minJumps(int[] arr, int pos, int steps, String s) {
		if (pos == arr.length - 1) {
			if (min > steps) {
				min = steps;
				System.out.println(s);
			}
			return;
		}

		if (memo.keySet().contains(pos)) {
			return;
		}
		memo.put(pos, steps);
		if (pos - 1 >= 0 && !memo.containsKey(pos - 1)) {
			minJumps(arr, pos - 1, steps + 1, s + "," + (pos - 1));
		}
		if (pos + 1 < arr.length && !memo.containsKey(pos + 1)) {
			minJumps(arr, pos + 1, steps + 1, s + "," + (pos + 1));
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == pos || arr[i] != arr[pos] || memo.keySet().contains(i))
				continue;
			minJumps(arr, i, steps + 1, s + "," + i);
		}
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLIS1(new int[] {10,7, 9,101,18},0,0));
	}
}