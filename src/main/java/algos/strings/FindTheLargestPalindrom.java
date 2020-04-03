package algos.strings;

public class FindTheLargestPalindrom {

	public static void main(String[] args) {
		String palindrome =new FindTheLargestPalindrom().findLargestPalindrome("abcddeffeddczzz");
		System.out.println("palindrome "+palindrome);

	}
	private String findLargestPalindrome(String str) {
		int max = 0;
		int palindromeStart = -1;
		int palindromeEnd = -1;
		String palindrome ="";
		int len = str.length();
		for (int i = 1; i < len; i++) {

			if (str.charAt(i) == str.charAt(i - 1)) {// we covered 0
				int fwd = i;
				int bk = i - 1;
				while (fwd < len && bk >= 0) {
					if (str.charAt(fwd) == str.charAt(bk)) {
						fwd++;
						bk--;
					}else{
						break;
					}
				}
				fwd--;
				bk++;
				if (max < fwd - bk + 1) {
					max = fwd - bk + 1;
					palindromeEnd = fwd;
					palindromeStart = bk;
				}
			}

			if (i + 1 < len && (str.charAt(i + 1) == str.charAt(i - 1))) {
				int fwd = i+1;
				int bk = i - 1;
				while (fwd < len && bk >= 0) {
					if (str.charAt(fwd) == str.charAt(bk)) {
						fwd++;
						bk--;
					}else{
						break;
					}
				}
				fwd--;
				bk++;
				if (max < fwd - bk + 1) {
					max = fwd - bk + 1;
					palindromeEnd = fwd;
					palindromeStart = bk;
				}
			}

		}
		if (palindromeEnd > palindromeStart  ){
			palindrome = str.substring(palindromeStart, palindromeEnd+1);
		}
		return palindrome;
	}
}
