import java.util.*;

public class Solution1 {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		// s.prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 0, 1 }, 826);
//		p.stream().forEach(e -> System.out.print(e + ","));
		s.addOperators("123", 1);
	}

	List<String> addOperatorsResults = null;

	public List<String> addOperators(String num, int target) {
		addOperatorsResults = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			sb.append(num.charAt(i));
			sb.append(":");
		}
		sb.replace(sb.length() - 1, sb.length()  , "");
		addOperators(sb, target, 1);
		addOperatorsResults.stream().forEach(System.out::println);
		return addOperatorsResults;
	}

	public void addOperators(StringBuilder num, int target, int pos) {
		if (pos >= num.length() - 1) {
//			addOperatorsResults.add(num.toString());
			return;
		}
		for (int i = pos; i <= num.length() - 2; i += 2) {
//			num.replace(pos, pos + 1, "*");
//			addOperatorsResults.add(num.toString());
//			addOperators(num, target, i + 2);
			
			num.replace(i, i+ 1, "-");
			addOperatorsResults.add(num.toString());
			addOperators(num, target, i + 2);
			
			
			num.replace(i, i+ 1, "+");
			addOperatorsResults.add(num.toString());
			addOperators(num, target, i + 2);
			num.replace(i, i+ 1, ":");
		}
	}

	private int sum(StringBuilder num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i += 2) {
			sum += Integer.valueOf(num.charAt(i));
		}
		return sum;
	}

	public int[] prisonAfterNDays(int[] cells, int N) {
		int len = cells.length;
		int[] cp = new int[len];
		HashMap<String, Integer> s = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cells.length; i++) {
			sb.append(cells[i]);
		}
		s.put(sb.toString(), 0);
		int k = 0;
		while (N != 0) {
			sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				if (i > 0 && i < len - 1 && cells[i - 1] == 0 && cells[i + 1] == 0) {
					cp[i] = 1;
				} else if (i > 0 && i < len - 1 && cells[i - 1] == 1 && cells[i + 1] == 1) {
					cp[i] = 1;
				} else {
					// i ==0 || i==len-1 ?0:cells[i]
					cp[i] = 0;
				}
				sb.append(cp[i]);
			}
			N--;
			k++;
			cells = Arrays.copyOf(cp, len);
			if (s.containsKey(sb.toString())) {
				System.out.println(sb.toString() + ": after " + s.get(sb.toString()));
			} else {
				s.put(sb.toString(), k);
				System.out.println(sb.toString() + ": inserting " + s.get(sb.toString()));
			}
		}
		return cells;
	}

	List<Integer> res = new ArrayList<>();

	public List<Integer> partitionLabels(String S) {
		partitionLabels(S, 0);
		return res;
	}

	public void partitionLabels(String s, int pos) {
		if (pos >= s.length())
			return;
		int lastIndex = pos;
		for (int i = pos; i <= lastIndex; i++) {
			char a = s.charAt(i);
			lastIndex = Math.max(s.lastIndexOf(a), lastIndex);
		}
		res.add(lastIndex - pos + 1);
		partitionLabels(s, lastIndex + 1);
	}
}
