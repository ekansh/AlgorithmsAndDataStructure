package algos.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class MergeIntervals {
 

	public static void main(String[] args) {
		MergeIntervals sol = new MergeIntervals();
		String [] words = {"a", "ap", "app","aaa", "appl",  "apply","apple","banana"};
//		String longestWord = new V().longestWord(words);
//		System.out.println(longestWord);
//		Set<String> s =Arrays.stream(words).collect( Collectors.toSet());
		
		Arrays.sort( words, (a,b) -> b.length() ==a.length()? a.compareTo(b):b.length()-a.length());
		Arrays.stream(words).forEach(e-> System.out.print(e+","));
		 System.out.println(words[0]+", "+words[1]);
		System.exit(0);
//		double myPow = new MergeIntervals().leastInterval(new char[] { 'A', 'A', 'B', 'B' }, 2);
//		System.out.println(myPow);
		List<List<Character>> asList = Arrays.asList(Arrays.asList('A', 'A', 'A', 'A', 'A'),
				Arrays.asList('B', 'B', 'B'), Arrays.asList('C'));
//		List<Character> mergeNList =  sol.mergeNList(asList,5);
//		String reorganizeString = sol.reorganizeString("aabcccd");
//		System.out.println(reorganizeString);

	}
}
class V {
    public String longestWord(String[] words) {
        Arrays.sort( words, (a,b) -> b.length() ==a.length()? a.compareTo(b):b.length()-a.length());
        Set<String> s =Arrays.stream(words).collect( Collectors.toSet());
        for(String word : words){
        	boolean wordFound=true;
            StringBuilder sb = new StringBuilder();
            for (int i =0; i<word.length(); i++){
                sb.append(word.charAt(i));
                if( !s.contains(sb.toString())){
                    wordFound=false;
                    break;
                }
            }
            if(wordFound){
                return word;
            }
        }
        return "";
    }
}
/*
["a", ,"ap", "app","aaa", "appl",  "apply","apple"| "banana",]
 Reverse sort , based on len if len is eq then lexicograph
 max_len, found 
 put all words in dict
 for each word in words 
 for each character in word check if all of them are  present in words
 if all of them are present , record its length . 
 
 
*/
