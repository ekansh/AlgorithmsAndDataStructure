package patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	public static final String EXAMPLE_TEST = "Wxyzabcaa1";
	
	public static boolean validateUsername(String[] args) {
		boolean usernameValidated=false;
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{5,}$");
		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		if (matcher.find()){
			usernameValidated=true;
		}
		return usernameValidated;
	}
	public static boolean validatePassword(String[] args) {
		boolean passwordValidated=false;
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
//		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		if (matcher.find()){
			passwordValidated=true;
		}
		return passwordValidated;
	}
	
	public static void main(String[] args) {
		System.out.println(validatePassword(null));
	}
}
