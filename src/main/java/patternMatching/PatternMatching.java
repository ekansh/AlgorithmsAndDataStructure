package patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
	public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

	public static void main(String[] args) {

		Pattern compile = Pattern.compile("\\d+");
		Matcher matcher2 = compile.matcher("sa");
		boolean matches2 = matcher2.matches();
		System.out.println(matches2);
		System.exit(11);
		
		Pattern pattern = Pattern.compile("\\w+");
		// in case you would like to ignore case sensitivity,
		// you could use this statement:
		// Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		// check all occurance
		boolean matches = matcher.matches();
		System.out.println(matches);
		while (matcher.matches()) {
			System.out.println("Start index: " + matcher.start() + " End index: " + matcher.end() + " string found "
					+ matcher.group());
		}
	}
}
