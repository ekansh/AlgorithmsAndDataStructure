package algos.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestCommonPresfixInString {
	public static void main(String[] args) {

		LongestCommonPresfixInString k = new LongestCommonPresfixInString();
		String[] s = { "dog","racecar","car" };
		String longestCommonPrefix = k.longestCommonPrefix(s);
		System.out.println(longestCommonPrefix);
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0) return"";
		Optional<String> min = Arrays.stream(strs).
				min((a, b) -> a.length() - b.length());
		String minString = min.get();
		StringBuilder sb = new StringBuilder();
		boolean foundInAll=false;
		for(int i =0;i<minString.length();i++) {
			foundInAll=true;
			for (String input : strs) {
				if(input.charAt(i)!=minString.charAt(i)) {
					foundInAll=false;
					break;
				}
			}
			if(foundInAll) {
				sb.append(minString.charAt(i));
			}else {
				break;
			}
		}
		return sb.toString();
	}
}
