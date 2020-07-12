package algos.strings;

import java.util.Stack;

public class LongestValidPara {
	public static void main(String[] args) {
		LongestValidPara paranthesis = new LongestValidPara();
		int l = paranthesis.numDecodings("12");
		System.out.println(l);
	}

	public int numDecodings(String s) {
		if (s.contains("0"))
			return 0;
		return numDecodings(s, 0,new StringBuilder(s));
	}

	public int numDecodings(String s, int pos, StringBuilder sb) {
		if (pos == s.length())
			return 1;
		if (s.length() == pos + 1)
			return 1;
		sb.insert(pos+1,',');
		int a = numDecodings(s, pos + 1,sb);
		sb.deleteCharAt(pos+1);
		int b = 0;
		if (pos + 2 <= s.length() && Integer.valueOf(s.substring(pos, pos + 2)) < 27) {
			sb.insert(pos+2,',');
			b = numDecodings(s, pos + 2,sb);
			sb.deleteCharAt(pos+2);
		}
		return a + b;
	}
}
