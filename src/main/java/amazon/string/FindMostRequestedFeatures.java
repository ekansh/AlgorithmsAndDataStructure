package amazon.string;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		input1();
		input2();
		int numFeatures=5;
		int topFeatures=2;
		String[] possibleFeatures= {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
		int numFeatureRequests=3;
		String featureRequests[]= {
				"I love anacell Best services provided by anacell in the town", 
				"betacellular has great services", 
				"deltacellular provides much better services than betacellular",
						"cetracular is worse than eurocell", "betacellular is better than deltacellular	"	 
		
		};
		solution.popularNFeatures(  numFeatures,   topFeatures,  Arrays.asList(possibleFeatures),
				  numFeatureRequests,  Arrays.asList(featureRequests));
	}

	private static void input2() {
		int numFeatures=5;
		int topFeatures=2;
		String[] possibleFeatures= { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
		int numFeatureRequests=3;
		String featureRequests[]= {
				"Best services provided by anacell", "betacellular has great services", "anacell provides much better services than all other" 				 
		};		
	}

	private static void input1() {
		int numFeatures=6;
		int topFeatures=2;
		String[] possibleFeatures= {"hover","battery","storage","alexa","waterproof","solar"};
		int numFeatureRequests=7;
		String featureRequests[]= {
				"I wish my Kindle had even more storage!",
				"I wish the battery life on my Kindle lasted 2 years.",
				"I read in the bath and would enjoy a waterproof Kindle", 
				"Waterproof and increased battery are my top two requests.",
				"I want to take my Kindle into the shower. Waterproof please waterproof !", 
				"It would be neat if my Kindle would hover on my desk when not in use.",
				"How cool would it be if my Kindle charged in the sun via solar power?"					 
		};		
	}

	public ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> r= new ArrayList<>();
		Map<String,Integer> mp= getMap(possibleFeatures);
		for (String st : featureRequests) {
			for (String string : possibleFeatures) {
				int k=getStringPresence(string,st);
				mp.put(string,mp.get(string)+k);
			}
		}
		r=getMostSoughtFeatures(mp,topFeatures);
		Collections.sort(r);
		r.stream().forEach(System.out::println);
		return r;
	}

	private ArrayList<String> getMostSoughtFeatures(Map<String, Integer> mp, int topFeatures) {
		ArrayList<String> r= new ArrayList<>();
		ArrayList<String> r1= new ArrayList<>();
		mp.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(e -> r.add(e.getKey()));
		for(int i = r.size()-1;i>topFeatures;i--) {
			r1.add(r.get(i));
		}
//		mp.entrySet()
//		  .stream()
//		 .filter(e -> e.getValue() >=topFeatures).forEach(e -> r.add(e.getKey()));
		return r1;
	}

	private int getStringPresence(String regex, String st) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(st);	

        int count = 0;
        while (matcher.find())
            count++;
        return count;
	}

	private Map<String, Integer> getMap(List<String> possibleFeatures) {
		Map<String,Integer> mp=new HashMap<>();
		for (String string : possibleFeatures) {
			mp.put(string,0);
		}
		return mp;
	}
	public ArrayList<String> popularNFeatures1(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> l = new ArrayList<String>();
		Map<String,Integer> possibleFeatureMap = new HashMap<>();
		for (String string : possibleFeatures) {
			possibleFeatureMap.put(string,0);
		}
		Set<String> featureRequestsSet = new HashSet<>(featureRequests);
		Pattern pattern = Pattern.compile("\\w+");
		for (String string : featureRequests) {
			Matcher matcher = pattern.matcher(string);
			while(matcher.matches()) {
				String group = matcher.group();
				if(possibleFeatureMap.get(group)!=null) {
					possibleFeatureMap.put(group,possibleFeatureMap.get(group)+1);
				}
			}
		}
		Map<String, Integer> sortByValue = sortByValue(possibleFeatureMap);
		int i =0;
		for(String s : sortByValue.keySet()) {
			l.add(s);
			i++;
			if (i==topFeatures)break;
		}
		
		
		l.stream().forEach(System.out::println);
		
		
		return l;
	}
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}










