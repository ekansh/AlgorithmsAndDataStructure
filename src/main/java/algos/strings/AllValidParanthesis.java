package algos.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AllValidParanthesis {
	public static void main(String[] args) {
		String l[] = new String[] { "ab", "ba", "azb" };
		Arrays.parallelSort(l, (x, y) -> x.length() == y.length() ? x.compareTo(y) : x.length() - y.length());
//		AllValidParanthesis s = new AllValidParanthesis();
//		boolean removeInvalidParentheses = isMatch("catter", "c.t*r");
//		System.out.println(removeInvalidParentheses);
		int t = findTargetSumWays("+++", 0);
		System.out.println(t);
//		System.out.println(mySqrt);
//		binarySearch1(new int[] {1,3,4,6,7,8,9}, 55);
//		System.out.println("---------");
//		binarySearch2(new int[] {1,3,4,6,7,8,9}, 55);
//		System.out.println("---------");
//		binarySearch3(new int[] {1,3,4,6,7,8,9}, 55);
	}

	public static int _findTargetSumWays(int[] nums, int S) {
		char op[] = new char[nums.length];
		Arrays.fill(op, '+');
		int total = _findTargetSumWays(nums, S, 0, op);

		return total;

	}

	static int count = 0;

	public static int findTargetSumWays(String string, int S) {
		calculate1(new StringBuilder(string), 0);
		return count;
	}

	public static void calculate2(StringBuilder s, int pos) {
	    for ( int i =0; i<pos; i++) System.out.print(" ");
		
		System.out.println("\"D:"+pos+"" + s + "\",");
		if (pos == s.length()) {
			return;
		}
		calculate2(s.replace(pos, pos + 1, "*"), pos + 1);
		calculate2(s.replace(pos, pos + 1, "="), pos + 1);
		s.replace(pos, pos + 1, "+");
	}

	public static void calculate1(StringBuilder s, int pos) {
//	    for ( int i =0; i<pos; i++) System.out.print(" ");
//		System.out.println("\"D:"+pos+"" + s + "\",");
		if (pos == s.length()) {
			return;
		}

		for (int i = pos; i < s.length(); i++) {
			for ( int j =0; j<pos; j++) System.out.print(" ");
			System.out.println("\"D:"+pos +""+ s.replace(i, i + 1, "*") + "\",");
//			calculate1(s.replace(i, i + 1, "="), i + 1);
			s.replace(i, i+ 1, "+");
		}

	}

	/*
	 * 2 3 6 | + + + 2 3 6 | - + + 2 3 6 | - - + 2 3 6 | - - - 2 3 6 | - - + 2 3 6 |
	 * - + - 2 3 6 | + + +
	 * 
	 */
	public static int _findTargetSumWays(int[] nums, int S, int pos, char op[]) {
		if (targetSumAchieve(nums, S, op)) {
			return 1;
		}
		if (pos == nums.length) {
			return 0;
		}
		int total = 0;
		for (int j = pos; j < nums.length; j++) {
			op[j] = '-';
			total += _findTargetSumWays(nums, S, j + 1, op);
			op[j] = '+';
		}
		return total;
	}

	public static boolean targetSumAchieve(int[] nums, int S, char op[]) {
		int sum = 0;
		for (int j = 0; j < nums.length; j++) {
			if (op[j] == '+') {
				System.out.print("+" + nums[j]);
				sum += nums[j];
			} else if (op[j] == '-') {
				System.out.print("-" + nums[j]);
				sum -= nums[j];
			}
		}
		System.out.println("-->" + sum);
		return sum == S;
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k <= 0)
			return 0;
		int left = 0, right = 0, max = 0;
		// count map
		Map<Character, Integer> map = new HashMap<>();
		while (right < s.length()) {
			char current = s.charAt(right++);
			map.put(current, map.getOrDefault(current, 0) + 1);

			if (map.size() > k) {
				int val = map.get(s.charAt(left));
				val = val - 1;
				if (val == 0) {
					map.remove(s.charAt(left));
				} else {
					map.put(s.charAt(left), val);
				}
				left++;
			}
			max = Math.max(max, right - left);

		}

		return max;
	}

	static int numOfEdit = 0;

	public static boolean isOneEditDistance(String s, String t) {
		if (s.length() < t.length())
			return isOneEditDistance(t, s);
		if (s.length() - t.length() > 1)
			return false;
		return oneEdit(s, t);

	}

	/**
	 * abec and aee
	 */
	public static boolean oneEdit(String s, String t) {
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) != t.charAt(j)) {
				numOfEdit++;
				if (numOfEdit == 2)
					return false;
				if (s.length() > t.length() && i + 1 < s.length())
					return oneEdit(s.substring(i + 1, s.length()), t.substring(j, t.length()));
				if (s.length() == t.length() && i + 1 < s.length() && j + 1 < t.length())
					return oneEdit(s.substring(i + 1, s.length()), t.substring(j + 1, t.length()));
			}
			i++;
			j++;

		}
		if (numOfEdit == 1 && i == s.length()) {
			return true;
		} else {
			return false;
		}

	}

	public static String addBinary(String a, String b) {
		if (a.length() < b.length())
			return addBinary(b, a);
		int[] r = new int[a.length() + 1];
		int mat[][] = new int[][] { { 0, 1 }, { 1, 10 } };
		int i = a.length() - 1, j = b.length() - 1;
		int p = r.length - 1;

		while (i >= 0 && j >= 0) {
			int v = mat[a.charAt(i) - '0'][r[p]];
			v = v == 10 ? v + (b.charAt(j) - '0') : mat[b.charAt(j) - '0'][v];
			r[p] = v % 10;
			r[p - 1] += v / 10;
			j--;
			i--;
			p--;
		}
		while (i >= 0) {
			int v = mat[a.charAt(i) - '0'][r[p]];
			r[p] = v % 10;
			r[p - 1] += v / 10;
			i--;
			p--;
		}
		int x = 0;
		while (x < r.length && r[x] == 0)
			x++;
		StringBuilder sb = new StringBuilder("");
		for (; x < r.length; x++) {
			sb.append(r[x]);
		}
		return sb.equals("") ? "" : sb.toString();
	}

	public static String mulitply(String a, String b) {
		int[] m = new int[a.length() + b.length()];
		int p1 = 0, p2 = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			for (int j = b.length() - 1; j >= 0; j--) {
				int v1 = a.charAt(i) - '0', v2 = b.charAt(j) - '0';
				int ans = v1 * v2 + m[p1];
				m[p1] = ans % 10;
				m[p1 + 1] += ans / 10;
				p1++;
			}
			p2++;
			p1 = p2;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = m.length - 1; i >= 0; i--) {
			sb.append(m[i]);
		}
		int k = 0;
		while (k < sb.length() && sb.charAt(k) == '0')
			k++;

//		
//		List<List<Integer>> res = new ArrayList<>();
//		for (int j = b.length() - 1; j >= 0; j--) {
//			int v2 = b.charAt(0) - '0';
//			int carry = 0;
//			List<Integer> r1 = new ArrayList<>();
//			for (int i = a.length() - 1; i >= 0; i--) {
//				int v1 = a.charAt(i) - '0';
//				r1.add((v2 * v1 + carry) % 10);
//				carry = (v2 * v1 + carry) / 10;
//			}
//			r1.add(carry);
//		}

		return k == sb.length() ? "0" : sb.substring(k).toString();
	}

	public static String minWindow(String s, String t) {

		int min = s.length();
		String res = "";
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> endCondition = new HashMap<>();
		Map<Character, Integer> val = new LinkedHashMap<Character, Integer>(16, .75f, true);

		for (int i = 0; i < t.length(); i++) {
			int v = map.getOrDefault(t.charAt(i), 0);
			map.put(t.charAt(i), v + 1);
		}
		int total = 0;
		int maxIndex = -1, minIndex = s.length();
		for (int j = 0; j < s.length(); j++) {
			if (map.containsKey(s.charAt(j))) {
				val.put(s.charAt(j), j);
				if (endCondition.get(s.charAt(j)) == null || endCondition.get(s.charAt(j)) < map.get(s.charAt(j))) {
					total++;
					int v = endCondition.getOrDefault(s.charAt(j), 0);
					endCondition.put(s.charAt(j), v + 1);
				}
			}
			// Putting this IF before the previous IF will create an awful bug
			if (total == t.length()) {
//				for (Iterator max = collection.iterator(); max.hasNext();) {
//					type type = (type) max.next();
//					
//				}
//				if (j - i + 1 <= min) {
//					min = j - i + 1;
//					res = s.substring(i, j + 1);
//				}
				System.out.println(res);
				endCondition.clear();
				break;
			}

		}
		System.out.println("final " + res);
		return res;
	}

	public static void nextPermutation(int[] nums) {
		int r = nums.length - 1;
		while (r - 1 >= 0 && nums[r] <= nums[r - 1])
			r--;
		r--;
		int temp, l = r + 1, nextBig = Integer.MAX_VALUE, i = l;
		while (l < nums.length) {
			if (r >= 0 && nums[l] > nums[r] && nums[l] <= nextBig) {
				nextBig = nums[l];
				i = l;
			}
			l++;
		}
		swap(nums, i, r);
		r++;
		int end = nums.length - 1;
		while (r < end) {
			swap(nums, r, end); // [2, 3, 7, 5, 4, 2, 2, 2, 1]
			r++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int r) {
		System.out.println("i = " + i + ":r=" + r);
		if (i >= 0 && i < nums.length && r >= 0 && r < nums.length) {
			int temp = nums[i];
			nums[i] = nums[r];
			nums[r] = temp;
		}
	}

	public static int mySqrt(int x) {
		if (x == 0)
			return 0;

		if (x == 1 || x == 2)
			return 1;
		int left = 2, right = x;

		while (left <= right) {

			int mid = left + (right - left) / 2;
			System.out.println("L=" + left + ",mid=" + mid + ",right=" + right);
			long prd = mid * mid;
			if (prd == x) {
				return mid;
			} else if (prd < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println("L=" + left + ",right=" + right);
		long r = right * right, l = left * left;
		if (r < x && l > x)
			return right;
		else
			return left;
	}

	public static boolean isMatch(String text, String pattern) {
		System.out.println("isMatch(" + text + "," + pattern + ")");
		if (pattern.isEmpty())
			return text.isEmpty();
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			System.out.println("-->isMatch(" + text + "," + pattern.substring(2) + ")");
			System.out.println("-->" + first_match + "&&" + "isMatch(" + text.substring(1) + "," + pattern + ")");
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			System.out.println(
					"-->" + first_match + "&&" + "isMatch(" + text.substring(1) + "," + pattern.substring(1) + ")");
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	static int binarySearch1(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left <= right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			System.out.println("L=" + left + ",mid=" + mid + ",right=" + right);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println("L=" + left + ",right=" + right);
		// End Condition: left > right
		return -1;
	}

	static int binarySearch2(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length;
		while (left < right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			System.out.println("L=" + left + ",mid=" + mid + ",right=" + right);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		// Post-processing:
		// End Condition: left == right
		System.out.println("L=" + left + ",right=" + right);
		if (left != nums.length && nums[left] == target)
			return left;
		return -1;
	}

	static int binarySearch3(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left + 1 < right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			System.out.println("L=" + left + ",mid=" + mid + ",right=" + right);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		// Post-processing:
		// End Condition: left + 1 == right
		System.out.println("L=" + left + ",right=" + right);
		if (nums[left] == target)
			return left;
		if (nums[right] == target)
			return right;
		return -1;
	}
}