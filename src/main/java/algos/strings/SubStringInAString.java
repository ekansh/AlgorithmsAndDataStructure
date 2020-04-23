package algos.strings;

public class SubStringInAString {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int i = sol.strStr("mississippi",				"issip");
		System.out.println(i);
	}
}

class Solution {
	public int strStr(String haystack, String needle) {
		int index = -1;
		int j = 0;//lllllppp	llppp
		if(needle.length()>haystack.length())return index;
		if(needle== null ||needle.length() ==0) return 0;

		for (int i = 0; i < haystack.length();) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				index = i;
				while (i < haystack.length() && j < needle.length() &&
						haystack.charAt(i) == needle.charAt(j)) {
					i++;
					j++;
				}
				if (j == needle.length()) {
					break;
				}else {
					j=0;
					i=index+1;
					index=-1;
				}
			}else {
				i++;
			}
		}
		return index;

	}
}