import java.util.HashSet;
import java.util.Set;

public class RegexImplOfDotQuestion {
private static boolean strCompare;
static Set<Character> set;
public static void main(String[] args) {
	RegexImplOfDotQuestion sol = new RegexImplOfDotQuestion();
	strCompare = RegexImplOfDotQuestion.strCompare("abcd", "5?a?bcde?");
	System.out.println(strCompare);
	set= new HashSet<>();
}
/*
 * 

abcd , ab?c?d:: acd  ad 

abcd , a?4?bcd
 */
//"abcd", "ar?bcd"
	
	public static boolean strCompare(String a, String regex) {
		int i = 0;
		int j=0;

		while (i <a.length() &&  j< regex.length()) {
			if( regex.charAt(j)=='.' ) {
				i++;j++;
				continue;
			}
			if(regex.charAt(j)=='?') {
				j++;
			}
			if(a.charAt(i) != regex.charAt(j)) {
				if(i+1<a.length() && j<regex.length() && regex.charAt(j+1) =='?') {
					return strCompare(
							a.substring(i, a.length()),
							regex.substring(j+2, regex.length())
							);
				}
			}

			if (a.charAt(i) != regex.charAt(j)) {
				return false;
			}
			i++;
			j++;
			
		}
		 
		if (j < regex.length()) {
			if(regex.charAt(j) =='?'||regex.charAt(j) =='.') {
				return true;
			}if(j+1<regex.length() && regex.charAt(j+1) =='?') {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}

}
