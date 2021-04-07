package patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main1(String[] args) {
		String example = "asender id: 116/sequence number: 117/depth: 443/sending time: 4/23/2020 2:08:54 AM/data: Hello I am SN: 116 this is event # 117 from my sideEnd-End Delay is:2.74550137092987E-05delay registered @ Sink: 621.932901880787";
		Pattern pattern = Pattern.compile("1{2}|7{1}");
		Matcher matcher = pattern.matcher(example);
		while (matcher.find()) {
			System.out.println(matcher.start() + ":" + matcher.end());
			System.out.println(matcher.group());
		}
	}

	public static void main(String[] args) {
		String input = "feee";
		String regex = constructRegex1 (input);
		System.out.println(regex);
//		 output : "l{1,2}e{1,3}t{1,3}c{1,1}o{1,3}d{1,3}e{1,2}";
		String[] dict = new String[] { "letcode", "leettccf", "lleetcode", "leetcod", "leettccf", "lleetcode",
				"leetcod", "leettccf", "leetcod" };
		Pattern pattern = Pattern.compile(regex);
		for (String string : dict) {
			Matcher matcher = pattern.matcher(string);
			boolean matches = matcher.matches();
			System.out.println(string + ":" + matches);
		}

	}

	private static String constructRegex(String input) {
		StringBuilder sb = new StringBuilder(input.charAt(0) + "{1,");
		int k = 1, i = 1; // aa ab
		for (i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				k++;
			} else {
				sb.append(k + "}");
				k = 1;
				sb.append(input.charAt(i) + "{1,");
			}

		}
		sb.append(k + "}");
		return sb.toString();
	}

	private static String constructRegex1(String input) {
		StringBuilder sb = new StringBuilder();
		int k = 1, i = 0;
		for (i = 0; i + 1 < input.length(); i++) {
			k = 1;
			sb.append(input.charAt(i) + "{1,");
			while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
				i++;
				k++;
			}
			sb.append(k + "}"); // aa ab
		}
		if (i == input.length() - 1) {
			sb.append(input.charAt(input.length() - 1) + "{1,1}");
		}
		return sb.toString();
	}
}
//0-9 are 48 -57
//a-z : 97 to 122
//A-Z : 65 to 90
