package algos.strings.manipulation;

import java.util.BitSet;
import java.util.Map;

/**
 * Remove duplicates in a string without extra buffer.
 * How in java one can do that without using extra buffer.
 * String is im-mutable
 * @author ekansh
 *
 */

public class RemoveDuplicatesInString {
	// static BitSet [] ascii = new BitSet[256];
	static byte[] ascii = new byte[256];

	public static void main(String[] args) {
		String str ="hello";
		StringBuilder s = new StringBuilder(str);

		boolean stringProcessed = false;
		int len = s.length();
		int i = 0;
		while (!stringProcessed) {
			int start = i;
			int end = -1;
			// check for a given character if we have duplicates and from where
			// to where
			while (isDuplicate(s.charAt(i))) {
				end = ++i;
			}
			if (end != -1) {
				// we found duplicates ranging from start to end
				s.delete(start, end);// so now shift character from (end to
										// the length of the string) to the
										// (start to the start+length of the
										// string)
			} else {// since we didnt find duplicates therefore move the counter
				i++;
			}
			if(i==s.length()){
				stringProcessed =true;
			}
			

		}
		System.out.println(s);
	}

	
	private static boolean isDuplicate(char charAt) {
		int index = charAt;
		boolean dupsFound = false;
		if (ascii[index] == 0) {
			ascii[index] = 1;

		} else {
			dupsFound = true;
		}
		return dupsFound;

	}
}
